package model.movement;

import model.Beacon;

import java.awt.Point;

/**
 * Mouvement de retour à la base
 */
public class BeaconBackMovement extends BeaconMovement {

	private int depth;
	
	public BeaconBackMovement(Movement next, int depth) {
		super(next);
		this.depth = depth;
	}
	
	@Override
	public void move(Beacon target) {
		Point p = target.getPosition();
		int y = p.y;
		if (y < this.depth) {
			y += 3;
			if (y > this.depth) y = this.depth;
			target.setPosition(new Point(p.x, y));
		}  else {
			target.setMovement(next);
		}
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
