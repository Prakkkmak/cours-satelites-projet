package model.visitor;

import model.element.Beacon;
import model.element.MobileElement;
import model.element.Satelitte;
import model.event.SatelitteMoved;
import model.visitor.IVisitor;

public class SatelitteUnregisterVisitor implements IVisitor {

    Beacon beacon;

    public SatelitteUnregisterVisitor(Beacon beacon){
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
        satelitte.unregisterListener(SatelitteMoved.class, this.beacon);
    }
}
