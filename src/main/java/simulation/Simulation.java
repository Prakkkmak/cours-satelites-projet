package simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import graphicLayer.GBounded;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import model.element.Beacon;
import model.element.MobileElement;
import model.movement.beacon.HorizontalMovement;
import model.movement.beacon.VerticalMovement;
import model.movement.satellite.BaseSatelliteMovement;
import model.movement.Movement;
import model.Manager;
import model.element.Satelitte;
import model.movement.satellite.SatelliteMovement;
import simulation.vue.GrBalise;
import simulation.vue.GrElementMobile;
import simulation.vue.GrSatelitte;

public class Simulation {

	GSpace world = new GSpace("Satellite & Balises", new Dimension(800, 600));
	private final GRect sea;
	private final GRect sky;
	private boolean pause = false;
	private Map<String, GrElementMobile> grElements;
	public Simulation(){
		grElements = new HashMap<>();
		sky = new GRect();
		sky.setColor(Color.WHITE);
		sky.setDimension(new Dimension(800, 300));
		sea = new GRect();
		sea.setColor(Color.blue);
		sea.setDimension(new Dimension(800, 300));
		sea.setPosition(new Point(0, 300));
		this.world.addElement(sky);
		this.world.addElement(sea);
		this.world.open();
		Thread t = new Thread(this::mainLoop);
		t.start();
	}
	public void mainLoop() {
		while (true) {
			if(!pause) Manager.getInstance().tick();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void pause(){
		pause = !pause;
	}
	
	public GrBalise addBalise(GBounded sea, int memorySize, Point startPos, Movement depl) {
		Beacon bal = new Beacon(memorySize);
		bal.setPosition(startPos);
		bal.setStartDepth(startPos.y);
		bal.setMovement(depl);
		Manager.getInstance().addElement(bal);
		GrBalise grbal = new GrBalise();
		grbal.setModel(bal);
		sea.addElement(grbal);
		return grbal;
	}
	public GrBalise addBalise(int memorySize, Point startPos, Movement depl) {
		return addBalise(sea, memorySize, startPos, depl);
	}

	public GrBalise addBalise(String id, int memorySize, Point startPos, Movement depl) {
		GrBalise grbal = addBalise(memorySize, startPos, depl);
		grElements.put(id, grbal);
		return grbal;
	}

	public GrSatelitte addSatelitte(GBounded sky, int memorySize, Point startPos, int speed) {
		Satelitte sat = new Satelitte(memorySize);
		sat.setPosition(startPos);
		sat.setMovement(new BaseSatelliteMovement(-10,1000, speed));
		Manager.getInstance().addElement(sat);
		GrSatelitte grSat = new GrSatelitte();
		grSat.setModel(sat);
		sky.addElement(grSat);
		return grSat;
	}

	public GrSatelitte addSatelitte(int memorySize, Point startPos, int speed) {
		return addSatelitte(sky, memorySize, startPos, speed);
	}

	public GrSatelitte addSatelitte(String id, int memorySize, Point startPos, int speed) {
		GrSatelitte grsat = addSatelitte(memorySize, startPos, speed);
		grElements.put(id, grsat);
		return grsat;
	}

	public void removeElement(String id){
		GrElementMobile grElementMobile = grElements.remove(id);
		Manager.getInstance().removeElement(grElementMobile.getModel());
	}

	public void changeSpeed(String id, int newValue){
		GrElementMobile grElementMobile = grElements.get(id);
		MobileElement mobileModel = grElementMobile.getModel();
		mobileModel.getMovement().setSpeed(newValue);
	}

	public void changeMovement(String id, Movement mov){
		GrElementMobile grElementMobile = grElements.get(id);
		MobileElement mobileModel = grElementMobile.getModel();
		mobileModel.setMovement(mov);
	}

	public void changeColor(String id, Color c){
		GrElementMobile grElementMobile = grElements.get(id);
		grElementMobile.setColor(c);
	}
	public void launch( ) {
		this.addSatelitte(sky, 10000, new Point(10,50), 2);
		this.addSatelitte(sky, 10000, new Point(100,10), 1);
		this.addSatelitte(sky, 10000, new Point(400,90), 3);
		this.addSatelitte(sky, 10000, new Point(500,140), 4);
		this.addSatelitte(sky, 10, new Point(0,150), 1);
		this.addBalise(sea, 100, new Point(300,200), new HorizontalMovement(50,750));
		this.addBalise(sea, 400, new Point(100,100), new VerticalMovement(50, 200));
		this.addBalise(sea, 200, new Point(0,160), new HorizontalMovement(0,800));
		this.addBalise(sea, 500, new Point(200,100), new VerticalMovement(130, 270));
		this.addBalise(sea, 150, new Point(300,100), new HorizontalMovement(200, 600));
	}

	public static void main(String[] args) {
		new Simulation().launch();
	}

}
