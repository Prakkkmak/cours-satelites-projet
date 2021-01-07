package model.movement.beacon;

import model.MobileElement;
import model.movement.satellite.BaseSatelliteMovement;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class HorizontalMovementTest {

    HorizontalMovement movement = new HorizontalMovement(0, 2);

    @Test
    void shouldMoveMobileElement() {
        MobileElement mobileElement = new MobileElement(10);
        movement.move(mobileElement);
        assertEquals(1, mobileElement.getPosition().x);
    }
    @Test
    void shouldMoveMobileElementBackwards() {
        MobileElement mobileElement = new MobileElement(10);
        movement.move(mobileElement);
        movement.move(mobileElement);
        movement.move(mobileElement);
        assertEquals(1, mobileElement.getPosition().x);
    }
}