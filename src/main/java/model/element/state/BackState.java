package model.element.state;

import model.element.Beacon;

public class BackState implements IBeaconState {
    @Override
    public IBeaconState next(Beacon beacon) {
        return new RecoverDataState();
    }
}
