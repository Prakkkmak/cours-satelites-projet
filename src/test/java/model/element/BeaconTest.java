package model.element;

import model.event.SatelitteMoved;
import model.movement.beacon.HorizontalMovement;
import model.movement.beacon.decorator.GoToSurfaceMovement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BeaconTest {

    Beacon beacon = new Beacon(10);

    @BeforeEach
    void init(){
        beacon.setStartDepth(10);
    }

    @Test
    void shouldBeInSurface() {
        beacon.setPosition(new Point(0,0));
        assertTrue(beacon.isInSurface());
    }

    @Test
    void shouldBeNotInSurface() {
        beacon.setPosition(new Point(0,1));
        assertFalse(beacon.isInSurface());
    }

    @Test
    void shouldReadSensors() {
        beacon.readSensors();
        assertEquals(1, beacon.getDataSize());
    }

    @Test
    void shouldTickReadSensors(){
        beacon.setPosition(new Point(0,1));
        beacon.setMovement(new HorizontalMovement(0,0));
        beacon.tick();
        assertEquals(1, beacon.getDataSize());
    }

    @Test
    void shouldHaveNextMovements() {
        beacon.setPosition(new Point(0,10));
        beacon.setDataSize(10);
        beacon.setMovement(new HorizontalMovement(0,0));
        beacon.tick();
        assertTrue(beacon.getMovement() instanceof GoToSurfaceMovement);
    }

    @Test
    void shouldSynchronize(){
        Satelitte satelitte = new Satelitte(10);
        SatelitteMoved satelitteMoved = new SatelitteMoved(satelitte);
        beacon.whenSatelitteMoved(satelitteMoved);
    }
}