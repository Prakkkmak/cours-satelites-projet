package model;

import model.element.Beacon;
import model.element.MobileElement;
import model.element.Satelitte;

public interface IVisitor {
    void visit(MobileElement mobileElement);
    void visit(Beacon beacon);
    void visit(Satelitte satelitte);
}
