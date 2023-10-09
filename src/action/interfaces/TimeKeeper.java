package action.interfaces;

import java.time.LocalTime;

// TimeKeeper interface for time-keeping logic
public interface TimeKeeper {
    // Method to start the time-keeping logic
	void start();

    // Method to get the current time
	LocalTime getCurrentTime();

    // Method to set a new time
	void setCurrentTime(LocalTime newTime);
}
