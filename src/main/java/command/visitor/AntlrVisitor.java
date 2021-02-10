package command.visitor;

import command.commands.*;
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
        super.visitScript(ctx);
        return new ScriptCommand(commands);
    }

    @Override
    public Command visitCreate(CreateContext ctx){
        super.visitCreate(ctx);
        Command createCommand = new CreateCommand(ctx.OBJ().getText(), ctx.pos().NB(0).getText(), ctx.pos().NB(1).getText(), ctx.NB().getText());
        commands.add(createCommand);
        return createCommand;
    }

    @Override
    public Command visitPause(AntlrSatParser.PauseContext ctx){
        super.visitPause(ctx);
        Command pauseCommand = new PauseCommand();
        commands.add(pauseCommand);
        return pauseCommand;
    }

    @Override
    public Command visitRemove(AntlrSatParser.RemoveContext ctx){
        super.visitRemove(ctx);
        Command removeCommand = new RemoveCommand(ctx.VAR().getText());
        return removeCommand;
    }

    @Override
    public Command visitAssign(AntlrSatParser.AssignContext ctx){
        super.visitAssign(ctx);
        CreateCommand createCommand = (CreateCommand) visitCreate(ctx.create());
        Command assignCommand = new AssignCommand(ctx.VAR().getText(), createCommand);
        return assignCommand;
    }

}
