package model;

import model.element.Beacon;
import model.element.MobileElement;
import model.element.Satelitte;
import model.event.SatelitteMoved;

import java.util.ArrayList;
import java.util.List;

public class Manager {

	public static Manager manager;


	List<MobileElement> elements = new ArrayList<>();

	private Manager(){ }

	public static Manager getInstance(){
		if(manager == null){
			manager = new Manager();
		}
		return manager;
	}

	public void addElement(MobileElement element){
		elements.add(element);
	}

	public void tick() {
		for (MobileElement element : this.elements) element.tick();
	}
	
	public void beaconReadyForSync(Beacon b) {
		for (MobileElement element : this.elements) {
			if(element instanceof Satelitte){
				element.registerListener(SatelitteMoved.class, b);
			}
		}
	}

	public void beaconSyncDone(Beacon b) {
		for (MobileElement element : this.elements) {
			if(element instanceof Satelitte){
				element.unregisterListener(SatelitteMoved.class, b);
			}
		}
	}

}
