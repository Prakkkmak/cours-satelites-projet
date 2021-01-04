package model;

public class Satelitte extends MobileElement {
			
	public Satelitte(int memorySize) {
		super(memorySize);
	}
	
	public void move() {
		super.move();
		this.send(new SatelitteMoved(this));		
	}
}
