package command;

import model.movement.beacon.HorizontalMovement;
import simulation.Simulation;

import java.awt.*;

public class SpawnCommand implements Command{
    private Simulation simulation;
    public SpawnCommand(Simulation sim){
        simulation = sim;
    }
    @Override
    public void execute(String... args) {
        String o = args[0];
        int posX = Integer.parseInt(args[1]);
        int posY = Integer.parseInt(args[2]);
        Point pos = new Point(posX, posY);
        int speed = Integer.parseInt(args[3]);
        if(o.equals('S')){
            simulation.addBalise(100 ,pos, new HorizontalMovement(50, 750));
            System.out.println("Spawn de balise");
        }
        else if(o.equals('B')){
            simulation.addSatelitte(100 ,pos, speed);
            System.out.println("Spawn de satelitte");
        }
    }
}
