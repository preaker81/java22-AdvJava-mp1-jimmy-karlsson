package main.interfaces;

import java.util.Scanner;
import state.StateEnum;

// StateMachine interface for managing states and actions
public interface StateMachine {
    // Method to change the current state
	void changeState(StateEnum target);

    // Method to perform an action based on the current state
	void performAction(Scanner sc);
}
