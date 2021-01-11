package model.movement.beacon.decorator;

import model.element.MobileElement;
import model.movement.Movement;

import java.awt.Point;

/**
 * Mouvement de retour à la base
 */
public class BackMovement extends BeaconMovementDecorator {

	private final int targetDepth;

	public BackMovement(Movement next, int targetDepth) {
		super(next);
		this.targetDepth = targetDepth;
	}
	
	@Override
	public void move(MobileElement target) {
		Point targetDepth = target.getPosition();
		int y = targetDepth.y;
		if (y < this.targetDepth) {
			y += this.speed;
			if (y > this.targetDepth) y = this.targetDepth;
			target.setPosition(new Point(targetDepth.x, y));
		}
		super.move(target);
	}

	@Override
	public boolean isReadyForNextMovement(MobileElement target) {
		return target.getPosition().getY() >= this.targetDepth;
	}
}
