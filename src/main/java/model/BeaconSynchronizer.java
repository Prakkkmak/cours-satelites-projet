package model;

import model.element.Beacon;
import model.element.MobileElement;
import model.element.Satelitte;
import model.event.SatelitteMoved;
import model.event.SynchroEvent;

/**
 * Gère la synchronisation avec les satélites
 */
public class BeaconSynchronizer {

    private static final int SYNC_RANGE = 50;

    private final Beacon beacon;
    private Satelitte satelitteInSync;

    public BeaconSynchronizer(Beacon beacon){
        this.beacon = beacon;
    }

    public Boolean isSyncInProgress() {
        return this.satelitteInSync != null;
    }

    public void startSync(Satelitte satellite){
        this.satelitteInSync = satellite;
        beacon.send(new SynchroEvent(this));
        satellite.send(new SynchroEvent(this));
    }

    public void stopSync(){
        Satelitte satellite = this.satelitteInSync;
        this.satelitteInSync = null;
        beacon.send(new SynchroEvent(this));
        satellite.send(new SynchroEvent(this));
    }

    public void sync(SatelitteMoved arg){
        Satelitte sat = this.satelitteInSync == null ? (Satelitte) arg.getSource() : this.satelitteInSync ;
        int satX = sat.getPosition().x;
        int tarX = beacon.getPosition().x;
        if (satX > tarX - SYNC_RANGE && satX < tarX + SYNC_RANGE) {
            if(this.satelitteInSync == null) startSync(sat);
            beacon.setDataSize(beacon.getDataSize() - 1);
            if(beacon.getDataSize() <= 0){
                stopSync();
                syncDone();
            }
        }
        else if(this.satelitteInSync != null){
            stopSync();
        }
    }

    public void readyForSync() {
        for (MobileElement element : Manager.getInstance().getElements()) {
            if(element instanceof Satelitte){
                element.registerListener(SatelitteMoved.class, beacon);
            }
        }
    }

    public void syncDone() {
        for (MobileElement element : Manager.getInstance().getElements()) {
            if(element instanceof Satelitte){
                element.unregisterListener(SatelitteMoved.class, beacon);
            }
        }
    }
}
