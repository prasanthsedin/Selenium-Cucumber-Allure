package utilities;

import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionHandler {

	private static final Logger logger = LogManager.getLogger(ExceptionHandler.class);

	/**
	 * Logs an exception to both the console log and the Extent Report.
	 */
	public static void logException(String context, Exception e) {
		String message = "Exception occurred in " + context + ": " + e.getMessage();
		logger.error(message, e);
		logToExtent(context, e);
	}

	/**
	 * Logs a throwable to both the console log and the Extent Report.
	 */
	public static void logException(String context, Throwable t) {
		String message = "Throwable occurred in " + context + ": " + t.getMessage();
		logger.error(message, t);
		logToExtent(context, t);
	}

	/**
	 * Logs a simple error message to both logger and Extent report.
	 */
	public static void logMessage(String context, String message) {
		logger.error("Error in {}: {}", context, message);
		ExtentTest extentTest = ExtentReportManager.getTest();
		if (extentTest != null) {
			extentTest.fail("Error in " + context + ": " + message);
		}
	}

	/**
	 * Logs and rethrows the given exception as a RuntimeException.
	 */
	public static RuntimeException logAndThrow(String context, Exception e) {
		logException(context, e);
		return new RuntimeException(e);
	}

	/**
	 * Internal helper method to log to the Extent report if the current test is available.
	 */
	private static void logToExtent(String context, Throwable t) {
		ExtentTest extentTest = ExtentReportManager.getTest();
		if (extentTest != null) {
			extentTest.fail("❌ Exception in **" + context + "**: " + t.getMessage());
		}
	}
}
