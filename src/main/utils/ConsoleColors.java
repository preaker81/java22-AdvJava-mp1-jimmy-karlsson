package main.utils;

// ConsoleColors class provides utility methods for setting console text colors
public class ConsoleColors {
	// ANSI escape codes for various colors
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	public static final String RESET = "\u001B[0m";

	// Method to set the console text color
	public static void setColor(String color) {
		switch (color.toLowerCase()) {
		case "black":
			System.out.print(BLACK);
			break;
		case "red":
			System.out.print(RED);
			break;
		case "green":
			System.out.print(GREEN);
			break;
		case "yellow":
			System.out.print(YELLOW);
			break;
		case "blue":
			System.out.print(BLUE);
			break;
		case "purple":
			System.out.print(PURPLE);
			break;
		case "cyan":
			System.out.print(CYAN);
			break;
		case "white":
			System.out.print(WHITE);
			break;
		case "reset":
			System.out.print(RESET);
			break;
		default:
			System.out.println("Invalid color");
			break;
		}
	}

	// Method to print text in a specific color
	public static void printColor(String color, String text) {
		setColor(color);
		System.out.println(text + RESET);
	}
}
