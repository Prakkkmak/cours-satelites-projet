package model.movement;

import model.MobileElement;

import java.awt.Point;

/**
 * Mouvement de retour à la base
 */
public class BackMovement extends BeaconMovement {

	private int targetDepth;
	
	public BackMovement(Movement next, int targetDepth) {
		super(next);
		this.targetDepth = targetDepth;
	}
	
	@Override
	public void move(MobileElement target) {
		Point p = target.getPosition();
		int y = p.y;
		if (y < this.targetDepth) {
			y += 3;
			if (y > this.targetDepth) y = this.targetDepth;
			target.setPosition(new Point(p.x, y));
		}  else {
			target.setMovement(next);
		}
	}

	public int getTargetDepth() {
		return targetDepth;
	}

	public void setTargetDepth(int targetDepth) {
		this.targetDepth = targetDepth;
	}
}
