package model.movement;

import model.Beacon;
import model.Satelitte;
import model.SatelitteMoved;
import model.SynchroEvent;
import model.movement.Movement;
import model.movement.BeaconMovement;

public class SyncMovement extends BeaconMovement {
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
	
	@Override
	public void whenSatelitteMoved(SatelitteMoved arg, Beacon target) {
		if (this.synchro != null) return;
		Satelitte sat = (Satelitte) arg.getSource();
		int satX = sat.getPosition().x;
		int tarX = target.getPosition().x;
		if (satX > tarX - 10 && satX < tarX + 10) {
			this.synchro = sat;
			target.send(new SynchroEvent(this));
			this.synchro.send(new SynchroEvent(this));
		}
	}

	@Override
	public void move(Beacon target) {
		if (this.synchro == null) return;
		this.synchroTime--;
		if (synchroTime <= 0) {
			Satelitte sat = this.synchro;
			this.synchro = null;
			this.synchroTime = 10;
			target.send(new SynchroEvent(this));
			sat.send(new SynchroEvent(this));
			target.getManager().baliseSyncDone(target);
			target.setMovement(next);
		}		
	}
}
