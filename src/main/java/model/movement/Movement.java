package model.movement;

import model.MobileElement;

public abstract class Movement {
	/**
	 * Déplace l'élément mobile à sa prochaine position
	 */
	abstract public void move(MobileElement target) ;
}
