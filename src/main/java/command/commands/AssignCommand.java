package command.commands;

import simulation.Simulation;

public class AssignCommand implements Command{

    String id;
    CreateCommand command;

    public AssignCommand(String id, CreateCommand command){
        this.id = id;
        this.command = command;
    }

    @Override
    public void execute(Simulation sim) {
        command.execute(sim, id);
        System.out.println("Element mobile assigné à " + id);
    }
}
