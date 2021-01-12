package model.event;

import model.element.Beacon;
import model.element.Satelitte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simulation.GrElementMobile;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PositionChangedTest {

    PositionChanged positionChanged;

    @BeforeEach
    void setUp() {
        Satelitte satelitte = new Satelitte(10);
        positionChanged = new PositionChanged(satelitte);
    }

    @Test
    void shouldRunOnWorks() {
        GrElementMobile grElementMobile = new GrElementMobile();
        assertEquals(0,grElementMobile.getPosition().x);
        Beacon beacon = new Beacon(10);
        beacon.setPosition(new Point(1,0));
        grElementMobile.setModel(beacon);
        positionChanged.runOn(grElementMobile);
        assertEquals(1,grElementMobile.getPosition().x);
    }
}