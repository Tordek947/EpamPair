package car_task.controller;

public class ControllerIsDisabledException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8212901109641496280L;

	@Override
	public String getMessage() {
		return "UIController is disabled. Please, enable it and try again";
	}
}
