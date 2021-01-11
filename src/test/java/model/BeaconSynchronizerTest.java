package model;

import model.element.Beacon;
import model.element.MobileElement;
import model.element.Satelitte;
import model.event.SatelitteMoved;
import org.junit.jupiter.api.Test;

import java.awt.*;

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
        SatelitteMoved satelitteMoved = new SatelitteMoved(satelitte);
        synchronizer.sync(satelitteMoved);
        assertTrue(synchronizer.isSyncInProgress());
    }

    @Test
    void shouldSyncResetData() {
        Satelitte satelitte = new Satelitte(10);
        SatelitteMoved satelitteMoved = new SatelitteMoved(satelitte);
        beacon.setDataSize(10);
        synchronizer.sync(satelitteMoved);
        assertEquals(0, beacon.getDataSize());
    }
}