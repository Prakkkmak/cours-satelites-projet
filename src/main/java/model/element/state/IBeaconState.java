package model.element.state;

import model.element.Beacon;

public interface IBeaconState {
    IBeaconState next(Beacon beacon);
}
