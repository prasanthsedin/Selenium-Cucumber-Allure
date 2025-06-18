package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionHandler {

	private static final Logger logger = LogManager.getLogger(ExceptionHandler.class);

	public static void logException(String context, Exception e) {
		logger.error("Exception occurred in {}: {}", context, e.getMessage(), e);
	}

	public static void logException(String context, Throwable t) {
		logger.error("Throwable occurred in {}: {}", context, t.getMessage(), t);
	}

	public static void logMessage(String context, String message) {
		logger.error("Error in {}: {}", context, message);
	}

	// Example of wrapping checked exception into runtime exception with logging
	public static RuntimeException logAndThrow(String context, Exception e) {
		logException(context, e);
		return new RuntimeException(e);
	}
}
