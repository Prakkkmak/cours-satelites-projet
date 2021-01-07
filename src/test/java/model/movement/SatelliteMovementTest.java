package model.movement;

import model.MobileElement;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SatelliteMovementTest {

    SatelliteMovement movement = new SatelliteMovement(0, 10, 1);

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