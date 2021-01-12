package model.element;

import model.IVisitor;
import model.event.SatelitteMoved;

public class Satelitte extends MobileElement {
			
	public Satelitte(int memorySize) {
		super(memorySize);
	}
	
	public void move() {
		super.move();
		this.send(new SatelitteMoved(this));
	}

	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
}
