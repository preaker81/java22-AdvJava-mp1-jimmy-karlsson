package action;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import action.interfaces.DateKeeper;
import action.interfaces.TimeKeeper;

// SecondTimeKeeper class implements the TimeKeeper interface
public class SecondTimeKeeper implements TimeKeeper {
    // Declare instance variables
	private LocalTime currentTime;
	private DateKeeper dateKeeper; // Add a reference to DateKeeper

    // Constructor to initialize the current time and DateKeeper reference
	public SecondTimeKeeper(LocalTime initialTime, DateKeeper dateKeeper) {
		this.currentTime = initialTime;
		this.dateKeeper = dateKeeper;
	}

    // Method to start the time-keeping logic
	public void start() {
        // Create a single-threaded scheduled executor
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        // Schedule a task to run every second to update the time
		scheduler.scheduleAtFixedRate(() -> {
			currentTime = currentTime.plusSeconds(1);
			if (currentTime.equals(LocalTime.MIDNIGHT)) {
                // If time reaches midnight, update the date
				dateKeeper.setCurrentDate(dateKeeper.getCurrentDate().plusDays(1));
			}
		}, 1, 1, TimeUnit.SECONDS);
	}

    // Method to get the current time
	public LocalTime getCurrentTime() {
		return currentTime;
	}

    // Method to set a new time
	public void setCurrentTime(LocalTime newTime) {
		this.currentTime = newTime;
	}
}
