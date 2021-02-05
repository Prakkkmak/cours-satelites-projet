package command;

import generated.AntlrSatLexer;
import generated.AntlrSatParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import simulation.Simulation;

public class CommandMain {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        String input = "spawn S 4 4 4";
        AntlrSatLexer lexer = new AntlrSatLexer(CharStreams.fromString(input));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        AntlrSatParser parser = new AntlrSatParser(tokenStream);
        ParseTree tree = parser.spawn();
        Command cmd = new SpawnCommand(simulation);
        cmd.execute(tree.getChild(0).toStringTree(), tree.getChild(1).toStringTree());
        System.out.println(tree.toStringTree());
    }

}
