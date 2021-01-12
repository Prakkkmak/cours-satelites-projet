package model;

import model.element.MobileElement;
import model.visitor.IVisitor;

import java.util.HashSet;
import java.util.Set;
//TODO virer le singleton
//TODO virer le getElements
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

	//Utilisable pour les tests
	public int size(){
		return elements.size();
	}

	public void tick() {
		for (MobileElement element : this.elements) element.tick();
	}

	public void visitElements(IVisitor visitor){
		for(MobileElement element : elements){
			element.accept(visitor);
		}
	}

}
