package model.movement.satellite;

import model.MobileElement;
import model.movement.satellite.BaseSatelliteMovement;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BaseSatelliteMovementTest {

    BaseSatelliteMovement movement = new BaseSatelliteMovement(0, 10);

    @Test
    void shouldMoveMobileElement() {
        MobileElement mobileElement = new MobileElement(10);
        movement.move(mobileElement);
        assertEquals(1, mobileElement.getPosition().x);
    }
    @Test
    void shouldGoToStartAtEnd() {
        MobileElement mobileElement = new MobileElement(10);
        mobileElement.setPosition(new Point(10,0));
        movement.move(mobileElement);
        assertEquals(0, mobileElement.getPosition().x);
    }
}