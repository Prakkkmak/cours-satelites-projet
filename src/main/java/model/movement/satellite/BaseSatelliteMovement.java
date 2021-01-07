package model.movement.satellite;

import model.MobileElement;

import java.awt.Point;

/**
 * Mouvement du satellite. Le mouvement permet au satellite de se déplacer de gauche à droite en boucle.
 */
public class BaseSatelliteMovement extends SatelliteMovement {
	private final Integer start;
	private final Integer end;
	private final int speed;

	public BaseSatelliteMovement(Integer start, Integer end, int speed) {
		this.start = start;
		this.end = end;
		this.speed = speed;
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
