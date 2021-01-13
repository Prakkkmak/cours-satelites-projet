package model.event;

import model.element.Beacon;
import model.element.Satelitte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simulation.vue.GrBalise;

class SynchroEventTest {

    SynchroEvent synchroEvent;
    Beacon beacon;

    @BeforeEach
    void setUp() {
        beacon = new Beacon(10);
        synchroEvent = new SynchroEvent(beacon.getBeaconSynchronizer());
    }

    @Test
    void shouldRunOnWorks() {
        beacon.setCurrentData(10);
        Satelitte satelitte = new Satelitte(10);
        SatelitteMoved satelitteMoved = new SatelitteMoved(satelitte);
        beacon.whenSatelitteMoved(satelitteMoved);
        SynchroEventListener synchroEventListener = new GrBalise();
        synchroEvent.runOn(synchroEventListener);
    }
}