package model.movement.beacon.decorator;

import model.MobileElement;
import model.movement.beacon.HorizontalMovement;
import model.movement.beacon.decorator.BackMovement;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BackMovementTest {

    HorizontalMovement horizontalMovement = new HorizontalMovement(0,1);
    BackMovement movement = new BackMovement(horizontalMovement, 10);
    MobileElement mobileElement = new MobileElement(10);

    @BeforeEach
    void init(){
        mobileElement.setMovement(movement);
    }

    @Test
    void shouldMoveMobileElement() {
        mobileElement.setPosition(new Point(0, 0));
        mobileElement.move();
        assertEquals(1, mobileElement.getPosition().y);
    }

    @Test
    void shouldChangeToNextMovement() {
        mobileElement.setPosition(new Point(10,10));
        mobileElement.move();
        assertTrue(mobileElement.getMovement() instanceof HorizontalMovement);
    }
}