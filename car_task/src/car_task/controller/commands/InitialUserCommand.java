package car_task.controller.commands;

public class InitialUserCommand extends UserCommand {


	@Override
	public StringBuffer executeCommand() {
		StringBuffer message = new StringBuffer();
		message.append("Добро пожаловать в наш маленький мирок автомобилей\n");
		message.append("Эта программа поможет Вам исследовать существующие автосалоны и ");
			message.append("просмотреть присутствующие в них машини, а также отфильтровать их ");
			message.append("по некоторым параметрам.");
		return message;
	}

	@Override
	public CommandType[] getAvailableCommands() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCommandActionDescription() {
		return null;
	}

}
