package command.commands;

import simulation.Simulation;

public class RemoveCommand implements Command{
    private String id;
    public RemoveCommand(String id){
        this.id = id;
    }
    @Override
    public void execute(Simulation sim) {
        sim.removeElement(id);
        System.out.println("Element mobile " + id + " supprimé.");
    }
}
