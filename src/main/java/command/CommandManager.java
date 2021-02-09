package command;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Map<String, Command> commands;
    public CommandManager(){
        commands = new HashMap<>();
    }
    /*
    public void registerCommand(String commandName, Command command){
        commands.put(commandName, command);
    }
    public void executeCommand(String commandName, String... args){
        commands.get(commandName).execute();
    }*/
}
