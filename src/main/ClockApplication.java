package main;

import java.util.Scanner;

import main.interfaces.StateMachine;
import state.State;
import state.StateEnum;

public class ClockApplication {
	String input = "";
	Scanner sc = new Scanner(System.in);

	public void run() {

		StateMachine stateMachine = new State(StateEnum.DISPLAY_TIME); // Starts in S1: Display Time

		while (input != "q") {
			StateEnum currentState = ((State) stateMachine).getCurrentState();
			switch (currentState) {
			case DISPLAY_TIME:
				displayTimeMenu(currentState, stateMachine);
				break;
			case DISPLAY_DATE:
				displayDateMenu(currentState);
				break;
			case CHANGE_TIME:
				changeTimeMenu(currentState);
				break;
			case CHANGE_DATE:
				changeDateMenu(currentState);
				break;
			default:
				break;
			}

		}

	}

	private void displayTimeMenu(StateEnum currentState, StateMachine stateMachine) {
		menuHeader(currentState);
		System.out.println("" + "1. Show Time" + "2. Switch to Change Time" + "3. Switch to Date Mode" + "4. Exit");

		int choice = -1;
		switch (choice) {
		case 1:
			stateMachine.performAction();
			break;
		case 2:
			stateMachine.changeState(StateEnum.CHANGE_TIME);
			break;
		case 3:
			stateMachine.changeState(StateEnum.DISPLAY_DATE);
			break;
		case 4:
			input = "q";
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}

	private void changeTimeMenu(StateEnum currentState, StateMachine stateMachine) {
		menuHeader(currentState);
		System.out.println("" + "1. Set Time" + "2. Switch to Display Time" + "3. Exit");

		int choice = -1;
		switch (choice) {
		case 1:
			stateMachine.performAction();
			break;
		case 2:
			stateMachine.changeState(StateEnum.DISPLAY_TIME);
			break;
		case 3:
			input = "q";
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}

	}

	private void displayDateMenu(StateEnum currentState, StateMachine stateMachine) {
		menuHeader(currentState);
		System.out.println("" 
		+ "1. Show Date" 
		+ "2. Switch to Change Date" 
		+ "3. Switch to Date Mode" 
		+ "4. Exit");

		int choice = -1;
		switch (choice) {
		case 1:
			stateMachine.performAction();
			break;
		case 2:
			stateMachine.changeState(StateEnum.CHANGE_TIME);
			break;
		case 3:
			stateMachine.changeState(StateEnum.DISPLAY_DATE);
			break;
		case 4:
			input = "q";
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}

	}

	private void changeDateMenu(StateEnum currentState, StateMachine stateMachine) {
		menuHeader(currentState);
		System.out.println("" + "1. Set Time" + "2. Switch to Display Time" + "3. Exit");

		int choice = -1;
		switch (choice) {
		case 1:
			stateMachine.performAction();
			break;
		case 2:
			stateMachine.changeState(StateEnum.DISPLAY_TIME);
			break;
		case 3:
			input = "q";
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}

	private void menuHeader(StateEnum currentState) {
		System.out.println("------------");
		System.out.println(currentState);
		System.out.println("------------");
	}

}
