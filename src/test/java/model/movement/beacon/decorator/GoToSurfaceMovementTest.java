package model.movement.beacon.decorator;

import model.element.Beacon;
import model.element.MobileElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GoToSurfaceMovementTest {
    SyncMovement syncMovement = new SyncMovement(null);
    GoToSurfaceMovement movement = new GoToSurfaceMovement(syncMovement);
    MobileElement mobileElement = new Beacon(10);

    @BeforeEach
    void init(){
        mobileElement.setMovement(movement);
    }

    @Test
    void shouldMoveMobileElement() {
        mobileElement.setPosition(new Point(0, 10));
        mobileElement.move();
        assertEquals(9, mobileElement.getPosition().y);
    }

    @Test
    void shouldChangeToNextMovement() {
        mobileElement.setPosition(new Point(0,0));
        mobileElement.move();
        assertTrue(mobileElement.getMovement() instanceof SyncMovement);
    }
}