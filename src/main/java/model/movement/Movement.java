package model.movement;

import model.MobileElement;

public abstract class Movement {
	abstract public void move(MobileElement target) ;
	public Movement replacement() { return this; } //TODO A supprimer
}
