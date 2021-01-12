package model.movement.beacon.decorator;

import model.element.MobileElement;
import model.movement.Movement;
import model.movement.beacon.BeaconMovement;

public abstract class BeaconMovementDecorator extends BeaconMovement {

    protected Movement next;

    public BeaconMovementDecorator(Movement next){
        this.next = next;
    }

    @Override
    public void move(MobileElement target){
        System.out.println(next + "");
        if(isReadyForNextMovement(target)) this.nextMovement(target);
    }

    public abstract boolean isReadyForNextMovement(MobileElement target);

    public void nextMovement(MobileElement target){
        target.setMovement(this.next);
    }
}
