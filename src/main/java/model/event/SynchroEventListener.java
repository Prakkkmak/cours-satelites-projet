package model.event;

import model.event.SynchroEvent;

public interface SynchroEventListener {
	void whenStartSynchro(SynchroEvent arg);
	void whenStopSynchro(SynchroEvent arg);
}
