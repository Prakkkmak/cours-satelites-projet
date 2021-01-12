package model;

import model.element.Beacon;
import model.element.MobileElement;
import model.element.Satelitte;
import model.event.SatelitteMoved;

public class SatelitteRegisterVisitor implements IVisitor {

    Beacon beacon;

    public SatelitteRegisterVisitor(Beacon beacon){
        this.beacon = beacon;
    }

    @Override
    public void visit(MobileElement mobileElement) {

    }

    @Override
    public void visit(Beacon beacon) {

    }

    @Override
    public void visit(Satelitte satelitte) {
        satelitte.registerListener(SatelitteMoved.class, this.beacon);
    }


}
