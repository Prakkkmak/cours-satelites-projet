package command;

import simulation.Simulation;

public class PauseCommand implements Command {
    @Override
    public void execute(Simulation simulation) {
        System.out.println("PAUSE");
        simulation.pause();
    }
}
