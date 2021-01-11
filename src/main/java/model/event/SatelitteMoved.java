package model.event;

import eventHandler.AbstractEvent;
import model.event.SatelitteMoveListener;

public class SatelitteMoved extends AbstractEvent {
	private static final long serialVersionUID = 480096146703824993L;

	public SatelitteMoved(Object source) {
		super(source);
	}

	public void runOn(Object target) {
		SatelitteMoveListener listener = (SatelitteMoveListener) target;
		listener.whenSatelitteMoved(this);
	}
}
