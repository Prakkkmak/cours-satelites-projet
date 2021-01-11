package model.event;

import eventHandler.AbstractEvent;
import model.BeaconSynchronizer;

public class SynchroEvent extends AbstractEvent {
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
