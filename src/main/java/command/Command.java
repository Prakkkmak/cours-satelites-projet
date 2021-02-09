package command;

import simulation.Simulation;

public interface Command {
    void execute(Simulation sim);
}
