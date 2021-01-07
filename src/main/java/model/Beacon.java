package model;

import model.movement.*;
import model.movement.beacon.BeaconMovement;
import model.movement.beacon.decorator.BackMovement;
import model.movement.beacon.decorator.GoToSurfaceMovement;
import model.movement.beacon.decorator.SyncMovement;

/**
 * La valise est un élément mobile qui as pour but de collecter des données et de les envoyer à un satellite.
 */
public class Beacon extends MobileElement implements SatelitteMoveListener{

	public Beacon(int memorySize) {
		super(memorySize);
	}
	
	public int getDepth() {
		return this.getPosition().y; 
	}
	
	protected void readSensors() {
		this.setDataSize(this.getDataSize() + 1);
	}
	
	public void tick() {
		this.readSensors();
		if (this.memoryFull()) {
			//TODO State pattern
			setNextMovements();
			//TODO Reset data au moment d'envoi
		} 
		super.tick();
	}

	public void setNextMovements(){
		Movement backMovement = new BackMovement(this.movement, this.getDepth());
		Movement syncMovement = new SyncMovement(backMovement);
		Movement goToSurfaceMovement = new GoToSurfaceMovement(syncMovement);
		this.setMovement(goToSurfaceMovement);
		this.resetData();
	}


	@Override
	public void whenSatelitteMoved(SatelitteMoved arg) {
		BeaconSynchronizer bs = new BeaconSynchronizer(this);
		bs.sync(arg);
	}


}
