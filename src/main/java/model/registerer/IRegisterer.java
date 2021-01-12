package model.registerer;

import model.element.Beacon;
import model.element.MobileElement;
import model.element.Satelitte;

public interface IRegisterer {
    default void run(MobileElement mobileElement){}
    default void run(Beacon beacon) {}
    default void run(Satelitte satelitte) {}
}
