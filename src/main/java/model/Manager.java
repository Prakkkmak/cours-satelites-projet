package model;

import model.element.Beacon;
import model.element.MobileElement;
import model.element.Satelitte;
import model.event.SatelitteMoved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Manager {

	public static Manager instance;


	private final Set<MobileElement> elements = new HashSet<>();

	private Manager(){ }

	public static Manager getInstance(){
		if(instance == null){
			instance = new Manager();
		}
		return instance;
	}

	public void addElement(MobileElement element){
		elements.add(element);
	}

	public Set<MobileElement> getElements(){
		return elements;
	}

	public int size(){
		return elements.size();
	}

	public void tick() {
		for (MobileElement element : this.elements) element.tick();
	}

}
