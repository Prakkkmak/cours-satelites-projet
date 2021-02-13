package command.commands;

import simulation.Simulation;

public class SpeedCommand implements Command {
    private final int speed;
    private final String id;
    public SpeedCommand(String id,int speed){
        this.id = id;
        this.speed = speed;
    }
    @Override
    public void execute(Simulation sim) {
        sim.changeSpeed(id, speed);
        System.out.println("Changement de la vitesse de " + id + " a " + speed);
    }
}
