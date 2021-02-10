package command.commands;

import command.commands.Command;
import simulation.Simulation;

public class PauseCommand implements Command {
    @Override
    public void execute(Simulation simulation) {
        simulation.pause();
        System.out.println("PAUSE");
    }
}
