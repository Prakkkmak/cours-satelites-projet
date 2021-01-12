package model.element;

import model.element.state.IBeaconState;
import model.element.state.RecoverDataState;
import model.registerer.IRegisterer;
import model.event.SatelitteMoveListener;
import model.event.SatelitteMoved;
import model.movement.*;
import model.movement.beacon.decorator.BackMovement;
import model.movement.beacon.decorator.GoToSurfaceMovement;
import model.movement.beacon.decorator.SyncMovement;

/**
 * La balise est un élément mobile qui as pour but de collecter des données et de les envoyer à un satellite.
 */
public class Beacon extends MobileElement implements SatelitteMoveListener {

	private final BeaconSynchronizer beaconSynchronizer;
	private int startDepth;
	private IBeaconState state;

	public Beacon(int memorySize) {
		super(memorySize);
		startDepth = this.getDepth();
		beaconSynchronizer = new BeaconSynchronizer(this);
		state = new RecoverDataState();
	}

	public BeaconSynchronizer getBeaconSynchronizer() {
		return beaconSynchronizer;
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

	public void readSensors() {
		this.setCurrentData(this.getCurrentData() + 1);
	}
	//TODO machine a etat
	@Override
	public void tick() {
		this.state = this.state.next(this);
		super.tick();
	}

	@Override
	public void whenSatelitteMoved(SatelitteMoved arg) {
		beaconSynchronizer.sync(arg);
	}

	public void setNextMovements(){
		Movement backMovement = new BackMovement(this.movement, this.startDepth);
		Movement syncMovement = new SyncMovement(backMovement);
		Movement goToSurfaceMovement = new GoToSurfaceMovement(syncMovement);
		this.setMovement(goToSurfaceMovement);
		beaconSynchronizer.readyForSync();
	}


	@Override
	public void register(IRegisterer registerer) {
		registerer.run(this);
	}
}
