package command.commands;

import simulation.Simulation;

import java.util.List;

public class ScriptCommand implements Command{
    private List<Command> commands;
    public ScriptCommand(List<Command> commands){
        this.commands = commands;
    }

    @Override
    public void execute(Simulation sim) {
        System.out.println("/////////// Execution du script..");
        commands.forEach((command -> command.execute(sim)));
        System.out.println("///////////Script executé");
    }
}
