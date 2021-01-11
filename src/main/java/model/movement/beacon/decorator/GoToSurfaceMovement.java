package model.movement.beacon.decorator;

import model.Beacon;
import model.MobileElement;
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
		} else {
			//TODO régler le probleme de cast target.getManager().beaconReadyForSync((Beacon) target);
			target.setMovement(this.next);
		}
	}
	
}
