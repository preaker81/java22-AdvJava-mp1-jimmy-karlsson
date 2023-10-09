package action.interfaces;

import java.time.LocalDate;

// DateKeeper interface for date-keeping logic
public interface DateKeeper {
    // Method to start the date-keeping logic
	void start();

    // Method to get the current date
	LocalDate getCurrentDate();

    // Method to set a new date
	void setCurrentDate(LocalDate newDate);
}
