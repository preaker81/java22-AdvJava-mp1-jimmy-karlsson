package action;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import main.utils.ConsoleColors;

public class Time extends Clock {
	private LocalTime currentTime;

	public Time() {
		this.currentTime = LocalTime.now();
	}

	public void displayAction() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		ConsoleColors.setColor("yellow");
		System.out.println("Display Time: " + currentTime.format(formatter));
		ConsoleColors.setColor("reset");
	}

	public void setAction(Scanner sc) {
		System.out.println("Enter new time in HH:mm:ss format");
		String newTimeStr = sc.next();
		try {
			currentTime = LocalTime.parse(newTimeStr);
			System.out.println("Time updated successfully.");
		} catch (Exception e) {
			System.out.println("Invalid time format. Time not updated.");
		}
	}
}
