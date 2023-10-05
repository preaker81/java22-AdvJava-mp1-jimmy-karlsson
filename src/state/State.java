package state;

import action.Date;
import action.Time;
import main.interfaces.StateMachine;

public class State implements StateMachine {
	private StateEnum currentState;

	public State(StateEnum currentState) {
		this.currentState = currentState;
	}

	@Override
	public void changeState(StateEnum targetState) throws IllegalStateException {
		StateEnum prevState = currentState; // Save the previous state for logging or debugging

		switch (currentState) {
		case DISPLAY_TIME:
			if (targetState == StateEnum.DISPLAY_DATE || targetState == StateEnum.CHANGE_TIME) {
				currentState = targetState;
				return; // Exit the method successfully
			}
			break;

		case DISPLAY_DATE:
			if (targetState == StateEnum.DISPLAY_TIME || targetState == StateEnum.CHANGE_DATE) {
				currentState = targetState;
				return; // Exit the method successfully
			}
			break;

		case CHANGE_TIME:
			if (targetState == StateEnum.DISPLAY_TIME) {
				currentState = targetState;
				return; // Exit the method successfully
			}
			break;

		case CHANGE_DATE:
			if (targetState == StateEnum.DISPLAY_DATE) {
				currentState = targetState;
				return; // Exit the method successfully
			}
			break;
		}

		// If we reach here, the state transition was not allowed
		throw new IllegalStateException("Invalid state transition from " + prevState + " to " + targetState);
	}

	@Override
	public void performAction() {
		switch (currentState) {
		case DISPLAY_TIME:
			new Time().displayAction();
			break;
		case DISPLAY_DATE:
			new Date().displayAction();
			break;
		case CHANGE_TIME:
			new Time().setAction();
			break;
		case CHANGE_DATE:
			new Date().setAction();
			break;
		}
	}

	public StateEnum getCurrentState() {
		return currentState;
	}
}