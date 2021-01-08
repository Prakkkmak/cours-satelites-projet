package model.movement.beacon.decorator;

import model.*;
import model.movement.Movement;

public class SyncMovement extends BeaconMovementDecorator {

	public SyncMovement(Movement next) {
		super(next);
	}

	@Override
	public void move(MobileElement target) {
		if(target.getDataSize() < 1) target.setMovement(this.next);
	}
}
