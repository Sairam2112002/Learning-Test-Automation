package learning.uitesting.selenium.exampleproblems.greenkartvegetables;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

public class BaseTest {
    protected static WebDriver driver;
    protected SoftAssertions softAssertions;
    protected Logger logger;

    protected final HashMap<String, String> xpathLocators = new HashMap<>();

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        logger = LogManager.getLogger(this.getClass());
        softAssertions = new SoftAssertions();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @AfterClass
    public void tearDown() {
        softAssertions.assertAll();
        driver.quit();
    }
}
