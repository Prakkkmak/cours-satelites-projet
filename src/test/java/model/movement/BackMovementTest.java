package model.movement;

import model.MobileElement;
import model.movement.beacon.HorizontalMovement;
import model.movement.beacon.decorator.BackMovement;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BackMovementTest {
    HorizontalMovement horizontalMovement = new HorizontalMovement(0,1);
    BackMovement movement = new BackMovement(horizontalMovement, 10);

    @Test
    void shouldMoveMobileElement() {
        MobileElement mobileElement = new MobileElement(10);
        mobileElement.setPosition(new Point(0, 0));
        movement.move(mobileElement);
        assertEquals(1, mobileElement.getPosition().y);
    }
    @Test
    void shouldChangeToNextMovement() {
        MobileElement mobileElement = new MobileElement(10);
        mobileElement.setPosition(new Point(10,0));
        movement.move(mobileElement);
        assertEquals(0, mobileElement.getPosition().x);
    }
}