package model.movement.beacon.decorator;

import model.MobileElement;
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
		}  else {
			target.setMovement(next);
		}
	}
}
