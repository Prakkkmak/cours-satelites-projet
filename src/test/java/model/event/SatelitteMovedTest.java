package model.event;

import model.element.Beacon;
import model.element.Satelitte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simulation.GrElementMobile;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SatelitteMovedTest {

    SatelitteMoved satelitteMoved;

    @BeforeEach
    void setUp() {
        Satelitte satelitte = new Satelitte(10);
        satelitteMoved = new SatelitteMoved(satelitte);
    }

    @Test
    void shouldRunOnWorks() {
        Beacon beacon = new Beacon(10);
        beacon.setDataSize(10);
        assertEquals(10, beacon.getDataSize());
        satelitteMoved.runOn(beacon);
        assertEquals(9, beacon.getDataSize());
    }
}