package model.registerer;

import model.element.Beacon;
import model.element.MobileElement;
import model.element.Satelitte;
import model.event.SatelitteMoved;

public class SatelitteRegisterRegisterer implements IRegisterer {

    Beacon beacon;

    public SatelitteRegisterRegisterer(Beacon beacon){
        this.beacon = beacon;
    }

    @Override
    public void run(Satelitte satelitte) {
        satelitte.registerListener(SatelitteMoved.class, this.beacon);
    }
}
