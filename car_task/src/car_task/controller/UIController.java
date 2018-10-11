package car_task.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import car_task.controller.commands.*;

public class UIController {
	private AutoShow[] autoShows;
	private int currentAutoShow;
	private UserCommand currentCommand;
	private List<UserCommand> availableCommands;
	private boolean enabled;
	private StringBuffer message;

	public UIController(AutoShow[] autoShows) {
		this.autoShows = autoShows;
		this.currentAutoShow = -1;
		this.enabled = false;
	}
	
	/*
	 * This method returns whether a user response was valid or not
	 */
	public boolean sendUserChoice(int request) throws ControllerIsDisabledException {
		if (!enabled) {
			throw new ControllerIsDisabledException();
		}
		if (request < 0 || request >= availableCommands.size()) {
			return false;
		}
		currentCommand = availableCommands.get(request);
		
		return true;
	}
	
	public StringBuffer enable() {
		enabled = true;
		currentCommand = buildCommands(CommandType.INITIAL).get(0);
		return getResponse();
	}

	private StringBuffer getResponse() {
		message = new StringBuffer();
		message.append(currentCommand.executeCommand());
		makeAvailableCommands();
		return message;
		
	}

	private List<UserCommand> buildCommands(CommandType commandType) {
		List<UserCommand> result = new ArrayList<UserCommand>();
		switch (commandType) {
		case CHOOSE_AUTO_SHOW:
			result.addAll(buildChooseAutoShowCommands());
			break;
		case CHOOSE_CAR_FILTER:
			result.addAll(buildChooseCarFilterCommands());
			break;
		case EXIT:
			break;
		case EXIT_AUTO_SHOW:
			break;
		case INITIAL:
			result.add(new InitialUserCommand());
			break;
		case PERFORM_CAR_FILTERS:
			break;
		case SHOW_ALL_CARS:
			break;
		case TO_AUTO_SHOW_ROOT:
			break;
		default:
			break;
		}
		return result;
	}


	private List<UserCommand> buildChooseAutoShowCommands() {
		List<UserCommand> result = new ArrayList<UserCommand>();
		for(var autoShow : autoShows) {
			result.add(new ChooseAutoShowCommand(autoShow));
		}
		
		return result;
	}

	private List<UserCommand> buildChooseCarFilterCommands() {
		List<UserCommand> result = new ArrayList<UserCommand>();
		for(var autoShow : autoShows) {
			result.add(new ChooseAutoShowCommand(autoShow));
		}
		
		return result;
	}

	private void makeAvailableCommands() {
		availableCommands = new ArrayList<>();
		addAvailableCommandsToList();
		addAvailableCommandsToMessage();
	}

	private void addAvailableCommandsToList() {
		var availableTypes = currentCommand.getAvailableCommands();
		for(var type : availableTypes) {
			availableCommands.addAll(buildCommands(type));
		}
	}

	private void addAvailableCommandsToMessage() {
		message.append("\nChoose an action:");
		int length = availableCommands.size();
		for(int i = 0;i<length;i++) {
			message.append("\n"+i+" "+availableCommands.get(i).getCommandActionDescription());
		}
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
}
