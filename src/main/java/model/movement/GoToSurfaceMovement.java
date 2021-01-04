package model.movement;

import model.Beacon;
import model.MobileElement;

import java.awt.Point;

public class GoToSurfaceMovement extends BeaconMovement {
	
	public GoToSurfaceMovement(Movement next) {
		super (next);
	}
		
	@Override
	public void move(MobileElement target) {
		Point p = target.getPosition();
		int y = p.y;
		if (y > 0) {
			y -= 3;
			if (y < 0) y = 0;
			target.setPosition(new Point(p.x, y));
		} else {
			target.getManager().beaconReadyForSync((Beacon) target);
			target.setMovement(this.next);
		}
	}
	
}
