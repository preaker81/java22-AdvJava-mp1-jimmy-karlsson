package action;

import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import action.interfaces.DateKeeper;

// DayDateKeeper class implements the DateKeeper interface
public class DayDateKeeper implements DateKeeper {
	// Declare instance variable to hold the current date
	private LocalDate currentDate;

	// Constructor to initialize the current date
	public DayDateKeeper(LocalDate initialDate) {
		this.currentDate = initialDate;
	}

	// Method to start the date-keeping logic
	public void start() {
		// Create a single-threaded scheduled executor
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		// Schedule a task to run every 24 hours to update the date
		scheduler.scheduleAtFixedRate(() -> {
			currentDate = currentDate.plusDays(1);
		}, 24, 24, TimeUnit.HOURS);
	}

	// Method to get the current date
	public LocalDate getCurrentDate() {
		return currentDate;
	}

	// Method to set a new date
	public void setCurrentDate(LocalDate newDate) {
		this.currentDate = newDate;
	}
}
