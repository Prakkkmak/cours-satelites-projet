package model.element.state;

import model.element.Beacon;

public class SyncState implements IBeaconState{
    @Override
    public IBeaconState next(Beacon beacon) {
        if(beacon.isMemoryEmpty()){
            return new GoToSurfaceState();
        }
        return this;
    }
}
