package model;

public class BeaconSynchronizer {
    private static final int SYNC_RANGE = 10;
    private Beacon beacon;
    private Satelitte synchro;
    public BeaconSynchronizer(Beacon beacon){
        this.beacon = beacon;
    }
    public void sync(SatelitteMoved arg){
        if (this.synchro != null) return;
        Satelitte sat = (Satelitte) arg.getSource();
        int satX = sat.getPosition().x;
        int tarX = beacon.getPosition().x;
        if (satX > tarX - SYNC_RANGE && satX < tarX + SYNC_RANGE) {
            this.synchro = sat;
            beacon.send(new SynchroEvent(this));
            this.synchro.send(new SynchroEvent(this));
        }
    }
}
