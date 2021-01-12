package model.movement.beacon.decorator;

import model.element.MobileElement;
import model.movement.Movement;

public class SyncMovement extends BeaconMovementDecorator {

	public SyncMovement(Movement next) {
		super(next);
	}

	@Override
	public void move(MobileElement target) {
		super.move(target);
	}

	@Override
	public boolean isReadyForNextMovement(MobileElement target) {
		return target.isMemoryEmpty();
	}
}
