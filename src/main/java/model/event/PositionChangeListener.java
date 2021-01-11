package model.event;

import model.event.PositionChanged;

public interface PositionChangeListener {
	void whenPositionChanged(PositionChanged arg);
}
