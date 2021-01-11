package model.movement.beacon;

import model.element.Beacon;
import model.element.MobileElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorizontalMovementTest {

    HorizontalMovement movement = new HorizontalMovement(0, 2);

    @Test
    void shouldMoveMobileElement() {
        MobileElement mobileElement = new Beacon(10);
        movement.move(mobileElement);
        assertEquals(1, mobileElement.getPosition().x);
    }
    @Test
    void shouldMoveMobileElementBackwards() {
        MobileElement mobileElement = new Beacon(10);
        movement.move(mobileElement);
        movement.move(mobileElement);
        movement.move(mobileElement);
        assertEquals(1, mobileElement.getPosition().x);
    }
}