package model;

import model.element.Beacon;
import model.element.Satelitte;
import model.event.SatelitteMoved;
import model.event.SynchroEvent;

/**
 * Gère la synchronisation avec les satélites
 */
public class BeaconSynchronizer {

    private static final int SYNC_RANGE = 10;

    private final Beacon beacon;
    private Satelitte satelitteInSync;

    public BeaconSynchronizer(Beacon beacon){
        this.beacon = beacon;
    }

    public Boolean isSyncInProgress() {
        return this.satelitteInSync != null;
    }

    public void sync(SatelitteMoved arg){
        if (this.satelitteInSync != null) return;
        Satelitte sat = (Satelitte) arg.getSource();
        int satX = sat.getPosition().x;
        int tarX = beacon.getPosition().x;
        if (satX > tarX - SYNC_RANGE && satX < tarX + SYNC_RANGE) {
            this.satelitteInSync = sat;
            beacon.send(new SynchroEvent(this));
            this.satelitteInSync.send(new SynchroEvent(this));
            beacon.resetData();
            this.satelitteInSync = null;
        }
    }
}
