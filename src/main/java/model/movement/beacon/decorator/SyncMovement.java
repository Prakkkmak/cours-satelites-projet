package model.movement.beacon.decorator;

import model.*;
import model.movement.Movement;

public class SyncMovement extends BeaconMovementDecorator {


	
	public SyncMovement(Movement next) {
		super(next);
	}

	//TODO Pourquoi whenSatellittteMoved ici ?
	//TODO anti pattern le move devrait déplacer seulement un Satellite
	@Override
	public void move(MobileElement target) {
		if(((Beacon)target).getDataSize() < 1) target.setMovement(this.next);
	}
	//TODO virer la sync d'ici, rien à faire dans un movement
}
