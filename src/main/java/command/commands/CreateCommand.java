package command.commands;

import command.commands.Command;
import model.movement.beacon.HorizontalMovement;
import simulation.Simulation;

import java.awt.*;

public class CreateCommand implements Command {

    private final String objectCode;
    private final String posX;
    private final String posY;
    private final String speed;

    public CreateCommand(String objectCode, String posX, String posY, String speed){
        this.objectCode = objectCode;
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
    }
    @Override
    public void execute(Simulation simulation) {
        execute(simulation, null);
    }

    public void execute(Simulation simulation, String var) {
        Point pos = new Point(Integer.parseInt(posX), Integer.parseInt(posY));
        if(objectCode.equals("B")){
            if(var != null) simulation.addBalise(var, 100 ,pos, new HorizontalMovement(50, 750));
            else simulation.addBalise(100 ,pos, new HorizontalMovement(50, 750));
            System.out.println("Spawn de balise");
        }
        else if(objectCode.equals("S")){
            if(var != null)simulation.addSatelitte(var, 100 ,pos, Integer.parseInt(speed));
            else simulation.addSatelitte(100 ,pos, Integer.parseInt(speed));
            System.out.println("Spawn de satelitte");
        }
    }
}
