package model.element.state;

import model.element.Beacon;

public class GoToSurfaceState implements IBeaconState{
    @Override
    public IBeaconState next(Beacon beacon) {
        if(beacon.isInSurface()){
            return new SyncState();
        }
        return this;
    }
}
