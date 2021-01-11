package model;

import model.element.Beacon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Manager manager = Manager.getInstance();

    @Test
    public void shouldAddAnElement(){
        manager.addElement(new Beacon(0));
        assertEquals(1, manager.size());
    }

    @Test
    public void shouldAddAnElementDuplicateNotInsered(){
        Beacon beacon = new Beacon(0);
        manager.addElement(beacon);
        assertEquals(1, manager.size());
        manager.addElement(beacon);
        assertEquals(1, manager.size());
    }

}