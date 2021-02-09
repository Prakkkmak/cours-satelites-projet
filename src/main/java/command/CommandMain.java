package command;

import generated.AntlrSatBaseVisitor;
import generated.AntlrSatLexer;
import generated.AntlrSatParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import simulation.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandMain {

    public static void main(String[] args) throws IOException {
        Simulation simulation = new Simulation();
        /*CommandManager commandManager = new CommandManager();
        commandManager.registerCommand("spawn", new CreateCommand());
        commandManager.registerCommand("pause", new PauseCommand());*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while(true){
            Command command = readCommand(input);
            command.execute(simulation);
            input = reader.readLine();
        }
    }

    public static Command readCommand(String input){
        AntlrSatLexer lexer = new AntlrSatLexer(CharStreams.fromString(input));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        AntlrSatParser parser = new AntlrSatParser(tokenStream);
        AntlrSatParser.CommandContext tree = parser.command();
        AntlrVisitor visitor = new AntlrVisitor();
        return visitor.visitCommand(tree);
    }

}
