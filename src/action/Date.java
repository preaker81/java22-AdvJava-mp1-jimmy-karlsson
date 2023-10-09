package action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

import action.interfaces.DateKeeper;
import main.utils.ConsoleColors;

// Date class extends the abstract Clock class
public class Date extends Clock {
    // Declare instance variables
    private DateKeeper dateKeeper;  // Using DateKeeper interface
    private String dateFormatRegEx = "\\d{4}-\\d{2}-\\d{2}";

    // Constructor accepts a DateKeeper object
    public Date(DateKeeper dateKeeper) {
        this.dateKeeper = dateKeeper;
        dateKeeper.start();  // Start the date-keeping logic
    }

    // Override displayAction method from Clock class
    @Override
    public void displayAction() {
        // Get current date from DateKeeper
        LocalDate currentDate = dateKeeper.getCurrentDate();
        
        // Format the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Display the date
        ConsoleColors.setColor("yellow");
        System.out.println("Display Date: " + currentDate.format(formatter));
        ConsoleColors.setColor("reset");
    }

    // Override setAction method from Clock class
    @Override
    public void setAction(Scanner sc) {
        // Prompt for new date
        System.out.println("Enter new date in yyyy-MM-dd format");
        String newDateStr = sc.next();

        // Validate date format using regex
        if (Pattern.matches(dateFormatRegEx, newDateStr)) {
            try {
                // Parse and set the new date
                LocalDate newDate = LocalDate.parse(newDateStr);
                dateKeeper.setCurrentDate(newDate);
                System.out.println("Date updated successfully.");
            } catch (Exception e) {
                System.out.println("Invalid date. Date not updated.");
            }
        } else {
            System.out.println("Invalid date format. Date not updated.");
        }
    }
}
