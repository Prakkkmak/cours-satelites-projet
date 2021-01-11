package model.movement.beacon;

import model.element.MobileElement;

import java.awt.Point;

public class HorizontalMovement extends BeaconMovement {
	private final Integer start;
	private final Integer end;
	private Boolean fromStartToEnd = true;

	public HorizontalMovement(Integer start, Integer end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void move(MobileElement target) {
		Point p = target.getPosition();
		int x = p.x;
		if (fromStartToEnd) {
			x += this.speed;
			if (x >= end) {
				x = end;
				fromStartToEnd = false;
			}
		} else {
			x -= this.speed;
			if (x <= start) {
				x = start;
				fromStartToEnd = true;
			}
		}
		target.setPosition(new Point(x, p.y));
	}

}
