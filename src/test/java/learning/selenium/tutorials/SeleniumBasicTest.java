package learning.selenium.tutorials;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumBasicTest {
    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(SeleniumBasicTest.class);

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\CS\\Browser Drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        LOGGER.info("Driver created");
    }

    @Test
    public void openBaseUri() {
        driver.get("https://www.selenium.dev/");
        LOGGER.info("Selenium Homepage Opened");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        LOGGER.info("Driver quit");
    }
}
