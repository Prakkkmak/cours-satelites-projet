package command.commands;

import simulation.Simulation;

public class AssignCommand implements Command{

    String id;
    Command command;

    public AssignCommand(String id, Command command){
        this.id = id;
        this.command = command;
    }

    @Override
    public void execute(Simulation sim) {
        ((CreateCommand)command).execute(sim, id);
        System.out.println("Element mobile assigné à " + id);
    }
}
