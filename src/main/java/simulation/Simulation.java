package simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import graphicLayer.GBounded;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import model.element.Beacon;
import model.movement.beacon.HorizontalMovement;
import model.movement.satellite.BaseSatelliteMovement;
import model.movement.Movement;
import model.Manager;
import model.element.Satelitte;

public class Simulation {

	GSpace world = new GSpace("Satellite & Balises", new Dimension(800, 600));
	
	public void mainLoop() {
		while (true) {
			Manager.getInstance().tick();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addBalise(GBounded sea, int memorySize, Point startPos, Movement depl) {
		Beacon bal = new Beacon(memorySize);
		bal.setPosition(startPos);
		bal.setStartDepth(startPos.y);
		bal.setMovement(depl);
		Manager.getInstance().addElement(bal);
		GrBalise grbal = new GrBalise();
		grbal.setModel(bal);
		sea.addElement(grbal);
	}

	public void addSatelitte(GBounded sky, int memorySize, Point startPos, int speed) {
		Satelitte sat = new Satelitte(memorySize);
		sat.setPosition(startPos);
		sat.setMovement(new BaseSatelliteMovement(-10,1000, speed));
		Manager.getInstance().addElement(sat);
		GrSatelitte grSat = new GrSatelitte();
		grSat.setModel(sat);
		sky.addElement(grSat);
	}
	
	public void launch( ) {
		GRect sky = new GRect();
		sky.setColor(Color.WHITE);
		sky.setDimension(new Dimension(800, 300));
		GRect sea = new GRect();
		sea.setColor(Color.blue);
		sea.setDimension(new Dimension(800, 300));
		sea.setPosition(new Point(0, 300));
		this.world.addElement(sky);
		this.world.addElement(sea);
		/*this.addSatelitte(sky, 10000, new Point(10,50), 2);
		this.addSatelitte(sky, 10000, new Point(100,10), 1);
		this.addSatelitte(sky, 10000, new Point(400,90), 3);
		this.addSatelitte(sky, 10000, new Point(500,140), 4);*/
		this.addSatelitte(sky, 10000, new Point(0,150), 1);
		this.addBalise(sea, 100, new Point(300,200), new HorizontalMovement(50,750));
		/*this.addBalise(sea, 400, new Point(100,100), new VerticalMovement(50, 200));
		this.addBalise(sea, 200, new Point(0,160), new HorizontalMovement(0,800));
		this.addBalise(sea, 500, new Point(200,100), new VerticalMovement(130, 270));
		this.addBalise(sea, 150, new Point(300,100), new HorizontalMovement(200, 600));*/
		this.world.open();
		this.mainLoop();
	}

	public static void main(String[] args) {
		new Simulation().launch();
	}

}
