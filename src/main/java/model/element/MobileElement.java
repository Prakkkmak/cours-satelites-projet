package model.element;

import java.awt.Point;

import eventHandler.AbstractEvent;
import eventHandler.EventHandler;
import model.registerer.IRegistrable;
import model.registerer.IRegisterer;
import model.event.PositionChanged;
import model.movement.Movement;

public abstract class MobileElement implements IRegistrable<IRegisterer> {
	protected Movement movement;
	protected Point position;
	protected EventHandler eventHandler;
	protected int memorySize;
	protected int currentData;

	public MobileElement(int memorySize) {
		eventHandler = new EventHandler();
		this.memorySize = memorySize;
		this.currentData = 0;
		this.position = new Point(0, 0);
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public int getCurrentData() {
		return currentData;
	}

	public void setCurrentData(int currentData) {
		this.currentData = currentData;
	}

	public void resetData() {
		this.currentData = 0;
	}

	public boolean isMemoryFull() {
		return (this.currentData >= this.memorySize);
	}
	public boolean isMemoryEmpty() {
		return (this.currentData <= 0);
	}
	// enregistrement des listeners
	public void registerListener(Class<? extends AbstractEvent> whichEventType, Object listener) {
		eventHandler.registerListener(whichEventType, listener);
	}

	public void unregisterListener(Class<? extends AbstractEvent> whichEventType, Object listener) {
		eventHandler.unregisterListener(whichEventType, listener);
	}

	// envoi des evenements
	public void send(AbstractEvent event) {
		eventHandler.send(event);
	}

	public void tick() {
		this.move();
	}

	public void move() {
		this.movement.move(this);
		this.send(new PositionChanged(this));
	}
}
