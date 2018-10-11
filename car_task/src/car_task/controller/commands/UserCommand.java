package car_task.controller.commands;

public abstract class UserCommand {
//	
//	private CommandType type;
//	
//	public UserCommand(CommandType type) {
//		this.type = type;
//	}
	
	public abstract String getCommandActionDescription();
	public abstract StringBuffer executeCommand();
	public abstract CommandType[] getAvailableCommands(); 
}
