package command.commands;

import simulation.Simulation;

public interface Command {
    void execute(Simulation sim);
}
