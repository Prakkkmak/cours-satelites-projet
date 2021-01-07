package model.movement.beacon;

import model.MobileElement;
import model.movement.beacon.BeaconMovement;

import java.awt.Point;

public class VerticalMovement extends BeaconMovement {
	Integer min;
	Integer max;
	Boolean monte = false;

	public VerticalMovement(Integer min, Integer max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void move(MobileElement target) {
		Point p = target.getPosition();
		int y = p.y;
		if (monte) {
			y -= 3;
			if (y < min) monte = false;
		} else {
			y += 3;
			if (y > max) monte = true;
		}
		target.setPosition(new Point(p.x, y));
	}

}
