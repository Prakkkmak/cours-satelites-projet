package model.registerer;

import model.element.Beacon;
import model.element.MobileElement;
import model.element.Satelitte;
import model.event.SatelitteMoved;

public class SatelitteUnregisterRegisterer implements IRegisterer {

    Beacon beacon;

    public SatelitteUnregisterRegisterer(Beacon beacon){
        this.beacon = beacon;
    }

    @Override
    public void run(Satelitte satelitte) {
        satelitte.unregisterListener(SatelitteMoved.class, this.beacon);
    }
}
