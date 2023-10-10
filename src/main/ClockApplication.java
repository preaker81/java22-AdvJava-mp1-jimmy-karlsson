package main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import main.utils.ConsoleColors;
import state.State;
import state.StateEnum;
import state.interfaces.StateMachine;
import action.interfaces.TimeKeeper;
import action.interfaces.DateKeeper;
import action.SecondTimeKeeper;
import action.DayDateKeeper;

public class ClockApplication {
	// Declare instance variables
	String input = "";
	Scanner sc = new Scanner(System.in);

	// Main method to run the application
	public void run() {
		// Initialize TimeKeeper and DateKeeper implementations
		DateKeeper dateKeeper = new DayDateKeeper(LocalDate.now());
		TimeKeeper timeKeeper = new SecondTimeKeeper(LocalTime.now(), dateKeeper);

		// Initialize the state machine starting in DISPLAY_TIME state
		StateMachine stateMachine = new State(StateEnum.DISPLAY_TIME, timeKeeper, dateKeeper);

		// Main loop to keep the application running until 'q' is entered
		while (!"q".equals(input)) {
			// Get the current state from the state machine
			StateEnum currentState = ((State) stateMachine).getCurrentState();

			// Switch case to handle different states
			switch (currentState) {
			case DISPLAY_TIME:
				displayTimeMenu(currentState, stateMachine);
				break;
			case DISPLAY_DATE:
				displayDateMenu(currentState, stateMachine);
				break;
			case CHANGE_TIME:
				changeTimeMenu(currentState, stateMachine);
				break;
			case CHANGE_DATE:
				changeDateMenu(currentState, stateMachine);
				break;
			default:
				break;
			}
		}
		// Close the scanner
		sc.close();
	}

	private void displayTimeMenu(StateEnum currentState, StateMachine stateMachine) {
		int choice = -1;
		
		menuHeader(currentState);
		stateMachine.performAction(sc);
		ConsoleColors.printColor("cyan", "----------------------------");
		
		System.out.println("" 
		+ "1. Set Clock Time \n" 
		+ "2. Switch to Date Mode \n"
		+ "3. Switch to Change Date (illegal state change) \n" 
		+ "4. Exit");

		System.out.println("Input: ");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			stateMachine.changeState(StateEnum.CHANGE_TIME);
			break;
		case 2:
			stateMachine.changeState(StateEnum.DISPLAY_DATE);
			break;
		case 3:
			stateMachine.changeState(StateEnum.CHANGE_DATE);
			break;
		case 4:
			System.out.println("Exiting system!");
			input = "q";
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}

	private void displayDateMenu(StateEnum currentState, StateMachine stateMachine) {
		int choice = -1;

		menuHeader(currentState);
		stateMachine.performAction(sc);
		ConsoleColors.printColor("cyan", "----------------------------");
		
		System.out.println("" 
		+ "1. Set Clock Date \n" 
		+ "2. Switch to Time Mode \n" 
		+ "3. Switch to Change Time (illegal state change) \n" 
		+ "4. Exit");

		System.out.println("Input: ");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			stateMachine.changeState(StateEnum.CHANGE_DATE);
			break;
		case 2:
			stateMachine.changeState(StateEnum.DISPLAY_TIME);
			break;
		case 3:
			stateMachine.changeState(StateEnum.CHANGE_TIME);
			break;
		case 4:
			System.out.println("Exiting system!");
			input = "q";
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}

	}
	
    private void changeTimeMenu(StateEnum currentState, StateMachine stateMachine) {
        menuHeader(currentState);
        stateMachine.performAction(sc);
    }

    private void changeDateMenu(StateEnum currentState, StateMachine stateMachine) {
        menuHeader(currentState);
        stateMachine.performAction(sc);
    }

	private void menuHeader(StateEnum currentState) {
		ConsoleColors.printColor("cyan", "" 
				+ "----------------------------\n"
				+ "\t" + currentState + "\n" 
				+ "----------------------------");
	}

}
