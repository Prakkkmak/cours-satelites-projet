package model.movement.satellite;

import model.element.MobileElement;
import model.movement.Movement;

public abstract class SatelliteMovement extends Movement {
    abstract public void move(MobileElement target) ;

}
