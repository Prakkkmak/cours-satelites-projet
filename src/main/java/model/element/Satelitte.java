package model.element;

import model.registerer.IRegisterer;
import model.event.SatelitteMoved;

public class Satelitte extends MobileElement {
			
	public Satelitte(int memorySize) {
		super(memorySize);
	}
	
	public void move() {
		super.move();
		this.send(new SatelitteMoved(this));
	}

	@Override
	public void register(IRegisterer registerer) {
		registerer.run(this);
	}
}
