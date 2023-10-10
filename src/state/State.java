package state;

import java.time.LocalTime;
import java.util.Scanner;

import action.Date;
import action.Time;
import action.SecondTimeKeeper;
import action.interfaces.DateKeeper;
import action.interfaces.TimeKeeper;
import main.utils.ConsoleColors;
import state.interfaces.StateMachine;

// State class implements StateMachine interface for managing states and actions
public class State implements StateMachine {
	private StateEnum currentState;  // Current state of the application

	private Time timeInstance;  // Time instance for time-related actions
	private Date dateInstance;  // Date instance for date-related actions

	// Constructor initializes the current state and instances of Time and Date
	public State(StateEnum currentState, TimeKeeper timeKeeper, DateKeeper dateKeeper) {
		this.currentState = currentState;

		this.timeInstance = new Time(timeKeeper);
		this.dateInstance = new Date(dateKeeper);

		// Initialize TimeKeeper with DateKeeper
		timeKeeper = new SecondTimeKeeper(LocalTime.now(), dateKeeper);
	}


	// Method to change the current state
	@Override
	public void changeState(StateEnum targetState) {
	    StateEnum prevState = currentState; // Save the previous state for logging or debugging

	    // Logic to validate state transitions
	    switch (currentState) {
	        case DISPLAY_TIME:
	            if (targetState == StateEnum.DISPLAY_DATE || targetState == StateEnum.CHANGE_TIME) {
	                currentState = targetState;
	                return; // Exit the method successfully
	            } else {
	                ConsoleColors.printColor("red", "Illegal state change. State remains " + currentState);
	            }
	            break;

	        case DISPLAY_DATE:
	            if (targetState == StateEnum.DISPLAY_TIME || targetState == StateEnum.CHANGE_DATE) {
	                currentState = targetState;
	                return; // Exit the method successfully
	            } else {
	                ConsoleColors.printColor("red", "Illegal state change. State remains " + currentState);
	            }
	            break;

	        case CHANGE_TIME:
	            if (targetState == StateEnum.DISPLAY_TIME) {
	                currentState = targetState;
	                return; // Exit the method successfully
	            } else {
	                ConsoleColors.printColor("red", "Illegal state change. State remains " + currentState);
	            }
	            break;

	        case CHANGE_DATE:
	            if (targetState == StateEnum.DISPLAY_DATE) {
	                currentState = targetState;
	                return; // Exit the method successfully
	            } else {
	                ConsoleColors.printColor("red", "Illegal state change. State remains " + currentState);
	            }
	            break;
	    }
	}


	// Method to perform an action based on the current state
    @Override
    public void performAction(Scanner sc) {
        switch (currentState) {
            case DISPLAY_TIME:
                timeInstance.displayAction();
                break;
            case DISPLAY_DATE:
                dateInstance.displayAction();
                break;
            case CHANGE_TIME:
                timeInstance.setAction(sc);
                // Automatically transition back to DISPLAY_TIME
                changeState(StateEnum.DISPLAY_TIME);
                break;
            case CHANGE_DATE:
                dateInstance.setAction(sc);
                // Automatically transition back to DISPLAY_DATE
                changeState(StateEnum.DISPLAY_DATE);
                break;
        }
    }

	// Method to get the current state
	public StateEnum getCurrentState() {
		return currentState;
	}
}
