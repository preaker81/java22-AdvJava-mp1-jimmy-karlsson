package main;

import java.util.Scanner;

import main.interfaces.StateMachine;
import main.utils.ConsoleColors;
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
		sc.close();
	}

	private void displayTimeMenu(StateEnum currentState, StateMachine stateMachine) {
		int choice = -1;
		menuHeader(currentState);
		System.out.println(
				"" + "1. Show Time \n" + "2. Switch to Change Time \n" + "3. Switch to Date Mode \n" + "4. Exit");

		System.out.println("Input: ");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			stateMachine.performAction(sc);
			break;
		case 2:
			stateMachine.changeState(StateEnum.CHANGE_TIME);
			break;
		case 3:
			stateMachine.changeState(StateEnum.DISPLAY_DATE);
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
		int choice = -1;
		menuHeader(currentState);
		System.out.println("" + "1. Set Time \n" + "2. Switch to Display Time \n" + "3. Exit");

		System.out.println("Input: ");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			stateMachine.performAction(sc);
			break;
		case 2:
			stateMachine.changeState(StateEnum.DISPLAY_TIME);
			break;
		case 3:
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
		System.out.println(
				"" + "1. Show Date \n" + "2. Switch to Change Date \n" + "3. Switch to Time Mode \n" + "4. Exit");

		System.out.println("Input: ");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			stateMachine.performAction(sc);
			break;
		case 2:
			stateMachine.changeState(StateEnum.CHANGE_DATE);
			break;
		case 3:
			stateMachine.changeState(StateEnum.DISPLAY_TIME);
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

	private void changeDateMenu(StateEnum currentState, StateMachine stateMachine) {
		int choice = -1;
		menuHeader(currentState);
		System.out.println("" + "1. Set Date \n" + "2. Switch to Display Time \n" + "3. Exit");

		System.out.println("Input: ");
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			stateMachine.performAction(sc);
			break;
		case 2:
			stateMachine.changeState(StateEnum.DISPLAY_DATE);
			break;
		case 3:
			System.out.println("Exiting system!");
			input = "q";
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}

	private void menuHeader(StateEnum currentState) {
		ConsoleColors.setColor("cyan");
		System.out.println("------------");
		System.out.println(currentState);
		System.out.println("------------");
		ConsoleColors.setColor("reset");
	}

}
