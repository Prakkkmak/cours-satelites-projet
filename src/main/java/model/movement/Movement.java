package model.movement;

import model.MobileElement;

public abstract class Movement {
	protected int speed = 1;
	/**
	 * Déplace l'élément mobile à sa prochaine position
	 */
	abstract public void move(MobileElement target) ;
}
