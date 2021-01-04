package model;

import model.movement.*;

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
		//TODO Sortir ce bloc dans une fonction exterieure
		if (this.memoryFull()) {
			//TODO State pattern
			Movement backMovement = new BeaconBackMovement(this.movement, this.getDepth());
			Movement syncMovement = new SyncMovement(backMovement);
			Movement goToSurfaceMovement = new GoToSurfaceMovement(syncMovement);
			this.setMovement(goToSurfaceMovement);
			//TODO Reset data au moment d'envoi
			this.resetData();
		} 
		super.tick();
	}


	@Override
	public void whenSatelitteMoved(SatelitteMoved arg) {
		BeaconMovement dp = (BeaconMovement) this.movement;
		dp.whenSatelitteMoved(arg, this);
	}


}