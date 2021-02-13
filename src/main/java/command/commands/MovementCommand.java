package command.commands;

import model.movement.beacon.HorizontalMovement;
import model.movement.beacon.VerticalMovement;
import simulation.Simulation;

public class MovementCommand implements Command{
    String movement;
    String id;
    public MovementCommand(String id, String movement){
        this.movement = movement;
        this.id = id;
    }

    @Override
    public void execute(Simulation sim) {
        switch (movement) {
            case "hor":
                sim.changeMovement(id, new HorizontalMovement(-20, 20));
            case "ver":
                sim.changeMovement(id, new VerticalMovement(-20, 20));
        }
        System.out.println("Changement du mouvement de " + id + " a " + movement);
    }
}
