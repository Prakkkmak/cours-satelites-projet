package model.event;

import eventHandler.AbstractEvent;

import java.io.Serial;

public class PositionChanged extends AbstractEvent {

	@Serial
	private static final long serialVersionUID = 480096146703824993L;

	public PositionChanged(Object source) {
		super(source);
	}

	public void runOn(Object target) {
		PositionChangeListener listener = (PositionChangeListener) target;
		listener.whenPositionChanged(this);
	}
}
