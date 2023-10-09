package action;

import java.util.Scanner;

// Declare Clock as an abstract class
public abstract class Clock {

	// Abstract method to display the time or date, to be implemented by subclasses
	public abstract void displayAction();

	// Abstract method to set the time or date, to be implemented by subclasses
	public abstract void setAction(Scanner sc);
}
