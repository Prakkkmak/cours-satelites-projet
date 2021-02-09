package command;

import generated.AntlrSatBaseVisitor;
import generated.AntlrSatParser;
import generated.AntlrSatParser.CommandContext;
import generated.AntlrSatParser.CreateContext;
import generated.AntlrSatParser.ScriptContext;

import java.util.ArrayList;
import java.util.List;

public class AntlrVisitor extends AntlrSatBaseVisitor<Command> {
    private final List<Command> commands = new ArrayList<>();

    public List<Command> getCommands(){
        return commands;
    }

    @Override
    public Command visitScript(ScriptContext ctx){
        Command lastCommand = null;
        for (CommandContext cmdContext: ctx.command()) {
            lastCommand = visitCommand(cmdContext);
        }
        return lastCommand;
    }


    @Override
    public Command visitCommand(CommandContext ctx){
        Command cmd = null;
        if(null != ctx.create()){
            cmd = visitCreate(ctx.create());
        }
        else if(null != ctx.pause()){
            cmd = visitPause(ctx.pause());
        }
        return cmd;
    }

    @Override
    public Command visitCreate(CreateContext ctx){
        Command createCommand = new CreateCommand(ctx.OBJ().getText(), ctx.NB(0).getText(), ctx.NB(1).getText(), ctx.NB(2).getText());
        commands.add(createCommand);
        return createCommand;
    }

    @Override
    public Command visitPause(AntlrSatParser.PauseContext ctx){
        Command pauseCommand = new PauseCommand();
        commands.add(pauseCommand);
        return pauseCommand;
    }


}
