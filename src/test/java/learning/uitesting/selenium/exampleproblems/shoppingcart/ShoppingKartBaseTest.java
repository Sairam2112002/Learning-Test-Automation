package learning.uitesting.selenium.exampleproblems.shoppingcart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.HashMap;

public class ShoppingKartBaseTest {
    private WebDriverWait webDriverWait;

    private static final long DEFAULT_TIME_OUT_IN_SECONDS = 5;

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

    public void waitForElementToBeVisible(String xpathLocator) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
    }
}
