package model.movement.satellite;

import model.element.MobileElement;
import model.element.Satelitte;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BaseSatelliteMovementTest {

    BaseSatelliteMovement movement = new BaseSatelliteMovement(0, 10);

    @Test
    void shouldMoveMobileElement() {
        MobileElement mobileElement = new Satelitte(10);
        movement.move(mobileElement);
        assertEquals(1, mobileElement.getPosition().x);
    }

    @Test
    void shouldMoveMobileElementWithSpeed() {
        BaseSatelliteMovement movementWithSpeed = new BaseSatelliteMovement(0, 10, 2);
        MobileElement mobileElement = new Satelitte(10);
        movementWithSpeed.move(mobileElement);
        assertEquals(2, mobileElement.getPosition().x);
    }

    @Test
    void shouldGoToStartAtEnd() {
        MobileElement mobileElement = new Satelitte(10);
        mobileElement.setPosition(new Point(10,0));
        movement.move(mobileElement);
        assertEquals(0, mobileElement.getPosition().x);
    }
}