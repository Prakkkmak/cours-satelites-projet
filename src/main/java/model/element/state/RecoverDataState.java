package model.element.state;

import model.element.Beacon;

public class RecoverDataState implements IBeaconState {
    @Override
    public IBeaconState next(Beacon beacon) {
        if(!beacon.isMemoryFull()){
            beacon.readSensors();
        }
        else{
            beacon.setNextMovements();
            return new BackState();
        }
        return this;
    }
}
