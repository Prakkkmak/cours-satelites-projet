package model.movement;

import model.Beacon;
import model.MobileElement;
import model.SatelitteMoved;

public class BeaconMovement extends Movement {

	protected Movement next;
	
	public BeaconMovement(Movement next) {
		this.next = next;
	}
	
	public void move(Beacon target) {
	}

	@Override
	public void move(MobileElement target) {
		this.move((Beacon) target);
	}

	public void whenSatelitteMoved(SatelitteMoved arg, Beacon target) { }

}
