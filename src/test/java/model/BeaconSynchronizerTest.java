package model;

import model.element.Beacon;
import model.element.BeaconSynchronizer;
import model.element.Satelitte;
import model.event.SatelitteMoved;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BeaconSynchronizerTest {

    Beacon beacon = new Beacon(10);
    BeaconSynchronizer synchronizer = new BeaconSynchronizer(beacon);

    @Test
    void shouldSyncIsNotInProgress() {
        assertFalse(synchronizer.isSyncInProgress());
    }

    @Test
    void shouldSyncIsInProgress() {
        Satelitte satelitte = new Satelitte(10);
        beacon.setCurrentData(10);
        SatelitteMoved satelitteMoved = new SatelitteMoved(satelitte);
        synchronizer.sync(satelitteMoved);
        assertTrue(synchronizer.isSyncInProgress());
    }

    @Test
    void shouldSyncRemoveData() {
        Satelitte satelitte = new Satelitte(10);
        SatelitteMoved satelitteMoved = new SatelitteMoved(satelitte);
        beacon.setCurrentData(10);
        synchronizer.sync(satelitteMoved);
        assertEquals(9, beacon.getCurrentData());
    }
}