package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestSelenium {

    // Global variables
    // Add extent reports
    private ExtentReports extent;
    private ExtentTest myTest;
    private static final String reportPath = System.getProperty("user.dir") + "\\test-output\\reportSanity.html";

    private WebDriver driver;
    private static String baseUrl;

    //pages

    private static final Logger logger = LogManager.getLogger(TestSelenium.class);

    @BeforeEach
    void beforeEach() {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
        baseUrl = "http://google.com";
        System.setProperty("webdriver.chrome.driver", "C:\\jars\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        //add general wait for elements
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // maximize window
        driver.manage().window().maximize();
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.get(baseUrl);
        //System.out.println("URL of the driver: " + driver.getCurrentUrl());
        logger.trace("URL of the driver: " + driver.getCurrentUrl());
        Thread.sleep(2000);

    }

    @AfterEach
    void afterEach() {
        logger.debug("finish test");
        driver.quit();
    }
}
