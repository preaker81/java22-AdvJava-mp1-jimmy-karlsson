package action;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

import action.interfaces.TimeKeeper;
import main.utils.ConsoleColors;

// Time class extends the abstract Clock class
public class Time extends Clock {
	// Declare instance variables
	private TimeKeeper timeKeeper; // Using TimeKeeper interface
	private String timeFormatRegEx = "\\d{2}:\\d{2}:\\d{2}";

	// Constructor accepts a TimeKeeper object
	public Time(TimeKeeper timeKeeper) {
		this.timeKeeper = timeKeeper;
		timeKeeper.start(); // Start the time-keeping logic
	}

	// Override displayAction method from Clock class
	@Override
	public void displayAction() {
		// Get current time from TimeKeeper
		LocalTime currentTime = timeKeeper.getCurrentTime();
		// Format the time
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		// Display the time
		ConsoleColors.printColor("yellow", "Display Time: " + currentTime.format(formatter));
	}

	// Override setAction method from Clock class
	@Override
	public void setAction(Scanner sc) {
		// Prompt for new time
		System.out.println("Enter new time in HH:mm:ss format");
		String newTimeStr = sc.next();

		// Validate the time format using regex
		if (Pattern.matches(timeFormatRegEx, newTimeStr)) {
			try {
				// Parse and set the new time
				LocalTime newTime = LocalTime.parse(newTimeStr);
				timeKeeper.setCurrentTime(newTime); // Update time using TimeKeeper
				ConsoleColors.printColor("green", "Time updated successfully.");
			} catch (Exception e) {
				ConsoleColors.printColor("red", "Invalid time. Time not updated.");
			}
		} else {
			ConsoleColors.printColor("red", "Invalid time format. Time not updated.");
		}
	}
}
