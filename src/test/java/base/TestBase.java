package base;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeEach
    public void initializeWebDriver() {
        setUp();
    }

    @AfterEach
    public void cleanupWebDriver() {
        tearDown();
    }

    public static void setUp() {
        if (driver == null) {
            try {
                Files.createDirectories(Paths.get("target", "screenshots"));
            } catch (IOException e) {
                System.out.println("Unable to create screenshot folder: " + e.getMessage());
            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static String captureScreenshot(String scenarioName) {
        if (driver == null) {
            return "";
        }

        Path screenshotDirectory = Paths.get("target", "screenshots");
        try {
            Files.createDirectories(screenshotDirectory);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String sanitizedScenarioName = scenarioName.replaceAll("[^a-zA-Z0-9_-]", "_");
            String fileName = sanitizedScenarioName + "-" + timestamp + ".png";
            Path screenshotPath = screenshotDirectory.resolve(fileName);

            TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
            byte[] screenshotBytes = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            Files.write(screenshotPath, screenshotBytes);

            System.out.println("Screenshot saved: " + screenshotPath.toAbsolutePath());
            return screenshotPath.toAbsolutePath().toString();
        } catch (IOException | ClassCastException e) {
            System.out.println("Unable to capture screenshot: " + e.getMessage());
            return "";
        }
    }
}
