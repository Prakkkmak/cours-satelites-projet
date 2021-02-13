package model.movement;

import model.element.MobileElement;

public abstract class Movement {
	protected int speed = 1;
	public void setSpeed(int speed){
		this.speed = speed;
	}
	public int getSpeed(){
		return this.speed;
	}
	/**
	 * Déplace l'élément mobile à sa prochaine position
	 */
	abstract public void move(MobileElement target) ;
}
