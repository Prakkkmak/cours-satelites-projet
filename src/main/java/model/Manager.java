package model;

import model.element.Beacon;
import model.element.Satelitte;
import model.event.SatelitteMoved;

import java.util.ArrayList;

public class Manager {
	ArrayList<Satelitte> sats = new ArrayList<Satelitte>();
	ArrayList<Beacon> bals = new ArrayList<Beacon>();
	public void addBeacon(Beacon bal) {
		bals.add(bal);
		bal.setManager(this);
	}
	public void addSatellite(Satelitte sat) {
		this.sats.add(sat);
		sat.setManager(this);
	}

	public void tick() {
		for (Beacon b : this.bals) {
			b.tick();
		}
		for (Satelitte s : this.sats) {
			s.tick();
		}
	}
	
	public void beaconReadyForSync(Beacon b) {
		for (Satelitte s : this.sats) {			
			s.registerListener(SatelitteMoved.class, b);
		}
	}
	public void baliseSyncDone(Beacon b) {
		for (Satelitte s : this.sats) {			
			s.unregisterListener(SatelitteMoved.class, b);
		}
	}

}
