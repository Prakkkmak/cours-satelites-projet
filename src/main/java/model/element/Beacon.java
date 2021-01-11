package model.element;

import model.BeaconSynchronizer;
import model.event.SatelitteMoveListener;
import model.event.SatelitteMoved;
import model.movement.*;
import model.movement.beacon.decorator.BackMovement;
import model.movement.beacon.decorator.BeaconMovementDecorator;
import model.movement.beacon.decorator.GoToSurfaceMovement;
import model.movement.beacon.decorator.SyncMovement;

/**
 * La balise est un élément mobile qui as pour but de collecter des données et de les envoyer à un satellite.
 */
public class Beacon extends MobileElement implements SatelitteMoveListener {

	private final BeaconSynchronizer beaconSynchronizer;
	private int startDepth;

	public Beacon(int memorySize) {
		super(memorySize);
		startDepth = this.getDepth();
		beaconSynchronizer = new BeaconSynchronizer(this);
	}

	public int getStartDepth() {
		return startDepth;
	}

	public void setStartDepth(int startDepth) {
		this.startDepth = startDepth;
	}

	public int getDepth() {
		return this.getPosition().y; 
	}

	public Boolean isInSurface() {
		return this.getDepth() <= 0;
	}

	protected void readSensors() {
		this.setDataSize(this.getDataSize() + 1);
	}
	
	public void tick() {
		if(!isInSurface()) this.readSensors();
		if (this.memoryFull() && !(this.movement instanceof BeaconMovementDecorator)) {
			setNextMovements();
		} 
		super.tick();
	}

	public void setNextMovements(){
		Movement backMovement = new BackMovement(this.movement, this.startDepth);
		Movement syncMovement = new SyncMovement(backMovement);
		Movement goToSurfaceMovement = new GoToSurfaceMovement(syncMovement);
		this.setMovement(goToSurfaceMovement);
		this.getManager().beaconReadyForSync(this);
	}


	@Override
	public void whenSatelitteMoved(SatelitteMoved arg) {
		beaconSynchronizer.sync(arg);
	}


}
