package model.movement.beacon;

import model.Beacon;
import model.MobileElement;
import model.SatelitteMoved;
import model.movement.Movement;

public abstract class BeaconMovement extends Movement {

	abstract public void move(MobileElement target) ;


}
