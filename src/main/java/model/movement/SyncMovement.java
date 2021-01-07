package model.movement;

import model.*;
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
	//TODO anti pattern le move devrait déplacer seulement un Satellite
	@Override
	public void move(MobileElement target) {
		if (this.synchro == null) return;
		this.synchroTime--;
		if (synchroTime <= 0) {
			Satelitte sat = this.synchro;
			this.synchro = null;
			this.synchroTime = 10;
			target.send(new SynchroEvent(this));
			sat.send(new SynchroEvent(this));
			//target.getManager().baliseSyncDone(target);
			target.setMovement(next);
		}		
	}
}
