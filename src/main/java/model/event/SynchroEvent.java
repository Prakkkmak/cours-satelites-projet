package model.event;

import eventHandler.AbstractEvent;
import model.element.BeaconSynchronizer;

import java.io.Serial;
//TODO regarder les events _> pê generique
public class SynchroEvent extends AbstractEvent {

	@Serial
	private static final long serialVersionUID = 480096146703824993L;

	public SynchroEvent(Object source) {
		super(source);
	}

	public void runOn(Object target) {
		SynchroEventListener listener = (SynchroEventListener) target;
		BeaconSynchronizer bs = (BeaconSynchronizer) this.getSource();
		if (bs.isSyncInProgress())
			listener.whenStartSynchro(this);
		else 
			listener.whenStopSynchro(this);
	}
}
