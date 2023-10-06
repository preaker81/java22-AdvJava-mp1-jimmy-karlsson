package action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import main.utils.ConsoleColors;

public class Date extends Clock {
	private LocalDate currentDate;

	public Date() {
		this.currentDate = LocalDate.now();
	}

	public void displayAction() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ConsoleColors.setColor("yellow");
		System.out.println("Display Date: " + currentDate.format(formatter));
		ConsoleColors.setColor("reset");
	}

	public void setAction(Scanner sc) { // Accept Scanner as parameter
		System.out.println("Enter new date in yyyy-MM-dd format");
		String newDateStr = sc.next();
		try {
			currentDate = LocalDate.parse(newDateStr);
			System.out.println("Date updated successfully.");
		} catch (Exception e) {
			System.out.println("Invalid date format. Date not updated.");
		}
	}
}
