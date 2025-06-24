package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import io.cucumber.java.AfterAll;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class ExtentReportManager {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static AtomicInteger passedCount = new AtomicInteger(0);
	private static AtomicInteger failedCount = new AtomicInteger(0);
	private static Instant suiteStartTime;
	private static Instant suiteEndTime;
	private static ExtentTest summary;

	static {
		suiteStartTime = Instant.now();
		initExtentReport();
	}

	private static void initExtentReport() {
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
		String reportPath = "target/test-output/reports/ExtentReport_" + timeStamp + ".html";

		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setDocumentTitle("Pricebook Automation Execution Report");
		spark.config().setReportName("Selenium Cucumber Test Results for Pricebook");
		spark.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("Browser", "Chrome");

		summary = extent.createTest("📊 Execution Summary (Live)");
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		ExtentTest scenarioTest = extent.createTest(scenario.getName());
		for (String tag : scenario.getSourceTagNames()) {
			scenarioTest.assignCategory(tag.replace("@", ""));
		}
		test.set(scenarioTest);
	}

	@AfterStep
	public void afterStep(Scenario scenario) {
		try {
			WebDriver driver = DriverFactory.getDriver();
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);

			String stepScreenshotName = "step_" + System.currentTimeMillis() + ".png";
			String relativePath = "../screenshots/" + stepScreenshotName;
			String absolutePath = "target/test-output/screenshots/" + stepScreenshotName;

			FileUtils.copyFile(src, new File(absolutePath));

			test.get().info("📸 Step screenshot:",
				MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());

		} catch (Exception e) {
			test.get().warning("⚠ Could not attach screenshot: " + e.getMessage());
		}
	}



	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			test.get().fail("Scenario Failed: " + scenario.getName());
			failedCount.incrementAndGet();
		} else {
			test.get().pass("Scenario Passed");
			passedCount.incrementAndGet();
		}
		DriverFactory.quitDriver();
	}

	private void captureAndAttachScreenshot(Scenario scenario) {
		try {
			WebDriver driver = DriverFactory.getDriver();
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);

			String screenshotFolder = "target/test-output/screenshots/";
			File screenshotDir = new File(screenshotFolder);
			if (!screenshotDir.exists()) {
				screenshotDir.mkdirs();
			}

			String screenshotName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + "_"
					+ System.currentTimeMillis() + ".png";
			String screenshotPath = screenshotFolder + screenshotName;
			File dest = new File(screenshotPath);
			FileUtils.copyFile(src, dest);

			test.get().fail("Step Failed - Screenshot:",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (IOException e) {
			test.get().warning("Failed to capture screenshot: " + e.getMessage());
		}
	}

	@AfterAll
	public static void afterAll() {
		suiteEndTime = Instant.now();
		Duration totalDuration = Duration.between(suiteStartTime, suiteEndTime);
		long minutes = totalDuration.toMinutes();
		long seconds = totalDuration.toSeconds() % 60;

		summary.info("✅ Passed Scenarios: " + passedCount.get());
		summary.info("❌ Failed Scenarios: " + failedCount.get());
		summary.info("🧪 Total Scenarios: " + (passedCount.get() + failedCount.get()));
		summary.info("⏱ Total Execution Time: " + minutes + " minutes " + seconds + " seconds");

		extent.flush();
	}

	public static ExtentTest getTest() {
		return test.get();
	}
}
