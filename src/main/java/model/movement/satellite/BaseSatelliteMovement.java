package model.movement.satellite;

import model.element.MobileElement;

import java.awt.Point;

/**
 * Mouvement du satellite. Le mouvement permet au satellite de se déplacer de gauche à droite en boucle.
 */
public class BaseSatelliteMovement extends SatelliteMovement {
	private final Integer start;
	private final Integer end;

	public BaseSatelliteMovement(Integer start, Integer end, int speed) {
		this(start, end);
		this.speed = speed;
	}
	public BaseSatelliteMovement(Integer start, Integer end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void move(MobileElement target) {
		Point startPoint = target.getPosition();
		int x = startPoint.x;
		x += speed;
		if (x > end) x = start;
		target.setPosition(new Point(x, startPoint.y));
	}

}
