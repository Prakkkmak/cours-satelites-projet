package model;

import model.element.Beacon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Manager manager;

    @BeforeEach
    public void init(){
        manager = Manager.getInstance();
    }

    @Test
    public void shouldAddAnElement(){
        manager.addElement(new Beacon(0));
        assertEquals(1, manager.size());
    }

    @Test
    public void shouldAddAnElementDuplicateNotInsered(){
        Beacon beacon = new Beacon(0);
        int sizeBefore = manager.size();
        manager.addElement(beacon);
        assertEquals(sizeBefore + 1, manager.size());
        manager.addElement(beacon);
        assertEquals(sizeBefore + 1, manager.size());
    }

}