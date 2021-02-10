package command;

import command.visitor.AntlrVisitor;
import command.commands.Command;
import generated.AntlrSatLexer;
import generated.AntlrSatParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import simulation.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommandMain {

    public static void main(String[] args) throws IOException {
        Simulation simulation = new Simulation();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        // si il y a un /, alors on cherche dans les scripts.
        if(input.startsWith("/"))
            input = Files.readString(Path.of("scripts" + input));
        while(true){
            Command command = readInput(input);
            if(command != null){
                command.execute(simulation);
            }
            input = reader.readLine();
        }
    }

    public static Command readInput(String input){
        try{
            AntlrSatLexer lexer = new AntlrSatLexer(CharStreams.fromString(input));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            AntlrSatParser parser = new AntlrSatParser(tokenStream);
            AntlrSatParser.ScriptContext tree = parser.script();
            AntlrVisitor visitor = new AntlrVisitor();
            return visitor.visitScript(tree);
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
        return null;
    }

}
