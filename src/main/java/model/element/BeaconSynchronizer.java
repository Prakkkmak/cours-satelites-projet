package model.element;

import model.Manager;
import model.element.Beacon;
import model.element.Satelitte;
import model.event.SatelitteMoved;
import model.event.SynchroEvent;
import model.registerer.SatelitteRegisterRegisterer;
import model.registerer.SatelitteUnregisterRegisterer;

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
            beacon.setCurrentData(beacon.getCurrentData() - 1);
            if(beacon.getCurrentData() <= 0){
                stopSync();
                syncDone();
            }
        }
        else if(this.satelitteInSync != null){
            stopSync();
            //TODO syncDone()
        }
    }

    public void readyForSync() {
        Manager.getInstance().registerElements(new SatelitteRegisterRegisterer(this.beacon));
    }

    public void syncDone() {
        Manager.getInstance().registerElements(new SatelitteUnregisterRegisterer(this.beacon));
    }
}
