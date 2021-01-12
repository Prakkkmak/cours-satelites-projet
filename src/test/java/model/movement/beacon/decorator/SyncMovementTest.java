package model.movement.beacon.decorator;

import model.element.Beacon;
import model.element.MobileElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SyncMovementTest {

    BackMovement backMovement = new BackMovement(null, 10);
    SyncMovement movement = new SyncMovement(backMovement);
    MobileElement mobileElement = new Beacon(2);

    @BeforeEach
    void init(){
        mobileElement.setMovement(movement);
        mobileElement.setCurrentData(2);
    }

    @Test
    void moveShouldDoesNothing() {
        mobileElement.setPosition(new Point(0, 0));
        mobileElement.move();
        assertEquals(0, mobileElement.getPosition().y);
        assertTrue(mobileElement.getMovement() instanceof SyncMovement);
    }

    @Test
    void shouldChangeToNextMovement() {
        mobileElement.setPosition(new Point(0, 0));
        mobileElement.setCurrentData(0);
        mobileElement.move();
        assertTrue(mobileElement.getMovement() instanceof BackMovement);
    }
}