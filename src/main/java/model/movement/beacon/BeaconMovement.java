package model.movement.beacon;

import model.element.MobileElement;
import model.movement.Movement;

public abstract class BeaconMovement extends Movement {

	abstract public void move(MobileElement target) ;


}
