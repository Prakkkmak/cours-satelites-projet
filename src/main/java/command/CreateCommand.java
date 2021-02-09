package command;

import model.movement.beacon.HorizontalMovement;
import simulation.Simulation;

import java.awt.*;

public class CreateCommand implements Command{

    private String objectCode;
    private String posX;
    private String posY;
    private String speed;

    public CreateCommand(String objectCode, String posX, String posY, String speed){
        this.objectCode = objectCode;
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
    }
    @Override
    public void execute(Simulation simulation) {
        Point pos = new Point(Integer.parseInt(posX), Integer.parseInt(posY));
        if(objectCode.equals("B")){
            simulation.addBalise(100 ,pos, new HorizontalMovement(50, 750));
            System.out.println("Spawn de balise");
        }
        else if(objectCode.equals("S")){
            simulation.addSatelitte(100 ,pos, Integer.parseInt(speed));
            System.out.println("Spawn de satelitte");
        }
    }
}
