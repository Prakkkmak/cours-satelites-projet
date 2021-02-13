package command.commands;

import model.movement.beacon.HorizontalMovement;
import model.movement.beacon.VerticalMovement;
import simulation.Simulation;

import java.awt.*;

public class ColorCommand implements Command{
    String id;
    String color;
    public ColorCommand(String id, String col){
        this.id = id;
        this.color = col;
    }
    @Override
    public void execute(Simulation sim) {
        switch (color) {
            case "blue":
                sim.changeColor(id, Color.BLUE);
            case "yellow":
                sim.changeColor(id, Color.YELLOW);
            case "green":
                sim.changeColor(id, Color.GREEN);
            /*default:
                sim.changeColor(id, new Color(Integer.parseInt(color)));*/
        }
    }
}
