package model;

import model.element.MobileElement;
import model.registerer.IRegisterer;

import java.util.HashSet;
import java.util.Set;
//TODO multithread ?
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
	public void removeElement(MobileElement element){elements.remove(element);}
	//Utilisable pour les tests
	public int size(){
		return elements.size();
	}

	public void tick() {
		for (MobileElement element : this.elements) element.tick();
	}

	public void registerElements(IRegisterer registerer){
		for(MobileElement element : elements){
			element.register(registerer);
		}
	}

}
