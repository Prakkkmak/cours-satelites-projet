package model.movement.beacon.decorator;

import model.*;
import model.movement.Movement;

public class SyncMovement extends BeaconMovementDecorator {

	private int synchroTime;
	private Satelitte synchro;
	
	public Boolean synchroStarted() {
		return this.synchro != null;
	}
	
	public SyncMovement(Movement next) {
		super(next);
		this.synchroTime = 10;
	}

	//TODO Pourquoi whenSatellittteMoved ici ?
	//TODO anti pattern le move devrait déplacer seulement un Satellite
	@Override
	public void move(MobileElement target) {
			sync(target);
	}
	//TODO virer la sync d'ici, rien à faire dans un movement
	public void sync(MobileElement target){
		if (this.synchro == null) return;
		this.synchroTime--;
		if (synchroTime <= 0) {
			Satelitte sat = this.synchro;
			this.synchro = null;
			this.synchroTime = 10;
			target.send(new SynchroEvent(this));
			sat.send(new SynchroEvent(this));
			target.getManager().baliseSyncDone((Beacon)target); // On sais que la target est un beacon ici
			target.setMovement(next);
		}
	}
}
