package model.movement;

import model.Beacon;
import model.MobileElement;
import model.SatelitteMoved;

public abstract class BeaconMovement extends Movement {

	protected Movement next;
	
	public BeaconMovement(Movement next) {
		this.next = next;
	}

	abstract public void move(MobileElement target) ;

	public void whenSatelitteMoved(SatelitteMoved arg, Beacon target) { }

}
