package model.movement.beacon.decorator;

import model.*;
import model.movement.Movement;

public class SyncMovement extends BeaconMovementDecorator {

	private static final int SYNC_RANGE = 10;
	private int synchroTime;
	private Satelitte synchro;
	
	public Boolean synchroStarted() {
		return this.synchro != null;
	}
	
	public SyncMovement(Movement next) {
		super(next);
		this.synchroTime = 10;
		this.synchro = null;
	}

	//TODO Pourquoi whenSatellittteMoved ici ?
	@Override
	public void whenSatelitteMoved(SatelitteMoved arg, Beacon target) {
		if (this.synchro != null) return;
		Satelitte sat = (Satelitte) arg.getSource();
		int satX = sat.getPosition().x;
		int tarX = target.getPosition().x;
		if (satX > tarX - SYNC_RANGE && satX < tarX + SYNC_RANGE) {
			this.synchro = sat;
			target.send(new SynchroEvent(this));
			this.synchro.send(new SynchroEvent(this));
		}
	}
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
