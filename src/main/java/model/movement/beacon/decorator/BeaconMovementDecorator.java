package model.movement.beacon.decorator;

import model.MobileElement;
import model.movement.Movement;
import model.movement.beacon.BeaconMovement;

public class BeaconMovementDecorator extends BeaconMovement {

    protected Movement next;

    public BeaconMovementDecorator(Movement next){
        this.next = next;
    }

    @Override
    public void move(MobileElement target) {

    }

}
