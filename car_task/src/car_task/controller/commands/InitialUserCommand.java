package car_task.controller.commands;

public class InitialUserCommand extends UserCommand {


	@Override
	public StringBuffer executeCommand() {
		StringBuffer message = new StringBuffer();
		message.append("����� ���������� � ��� ��������� ����� �����������\n");
		message.append("��� ��������� ������� ��� ����������� ������������ ���������� � ");
			message.append("����������� �������������� � ��� ������, � ����� ������������� �� ");
			message.append("�� ��������� ����������.");
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
