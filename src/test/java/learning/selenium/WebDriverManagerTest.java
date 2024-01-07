package learning.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverManagerTest {
    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(WebDriverManagerTest.class);

    @BeforeClass
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
