package learning.uitesting.selenium.complexscenarios.datehandling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DateHandlingBaseTest {
    protected WebDriver driver;
    protected Logger logger;

    protected static final String RAHUL_SHETTY_ACADEMY_GREEN_KART_TOP_DEALS_URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";

    @BeforeMethod
    public void beforeMethod() {
        logger = LogManager.getLogger(this.getClass());
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
