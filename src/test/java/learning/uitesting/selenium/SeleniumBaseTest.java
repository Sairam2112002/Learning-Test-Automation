package learning.uitesting.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class SeleniumBaseTest {
    protected WebDriver driver;
    protected Logger logger;

    protected static final String NOP_COMMERCE_URL = "https://www.nopcommerce.com/en/demo";
    protected static final String GOOGLE_SEARCH_URL = "https://www.google.com/";

    @BeforeClass
    public void baseSetup() {
        logger = LogManager.getLogger(this.getClass());
    }

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
