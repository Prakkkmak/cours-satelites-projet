package model.visitor;

import model.visitor.IVisitor;

public interface IVisitable<T extends IVisitor>  {
    void accept(T visitor);
}
