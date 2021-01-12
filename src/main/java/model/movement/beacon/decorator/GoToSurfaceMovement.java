package model.movement.beacon.decorator;

import model.element.MobileElement;
import model.movement.Movement;

import java.awt.Point;

public class GoToSurfaceMovement extends BeaconMovementDecorator {
	
	public GoToSurfaceMovement(Movement next) {
		super (next);
	}
		
	@Override
	public void move(MobileElement target) {
		Point p = target.getPosition();
		int y = p.y;
		if (y > 0) {
			y -= this.speed;
			if (y < 0) y = 0;
			target.setPosition(new Point(p.x, y));
		}
		super.move(target);
	}

	@Override
	public boolean isReadyForNextMovement(MobileElement target) {
		return target.getPosition().getY() <= 0;
	}
}
