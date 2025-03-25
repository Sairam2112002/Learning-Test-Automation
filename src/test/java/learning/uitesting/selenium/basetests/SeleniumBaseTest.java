package learning.uitesting.selenium.basetests;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class SeleniumBaseTest {
    private WebDriverWait webDriverWait;

    private static final long DEFAULT_TIME_OUT_IN_SECONDS = 5;

    protected static WebDriver driver;
    protected Logger logger;
    protected final HashMap<String, String> xpathLocators = new HashMap<>();

    protected static final String NOP_COMMERCE_URL = "https://www.nopcommerce.com/en/demo";
    protected static final String GOOGLE_SEARCH_URL = "https://www.google.com/";
    protected static final String MDN_WEB_DOCS_URL = "https://developer.mozilla.org/en-US/";
    protected static final String EXAMPLE_URL = "http://example.com";
    protected static final String WIKIPEDIA_URL = "https://www.wikipedia.org/";
    protected static final String OPEN_CART_URL = "https://naveenautomationlabs.com/opencart/";
    protected static final String SPICEJET_URL = "https://www.spicejet.com/";
    protected static final String HEROKU_URL = "https://the-internet.herokuapp.com/";
    protected static final String HEROKU_CHECKBOXES_URL = "https://the-internet.herokuapp.com/checkboxes";
    protected static final String HEROKU_JS_ALERTS_URL = "https://the-internet.herokuapp.com/javascript_alerts";
    protected static final String HEROKU_DYNAMIC_LOADING_HIDDEN_ELEMENT_URL = "https://the-internet.herokuapp.com/dynamic_loading/1";
    protected static final String HEROKU_DRAG_AND_DROP_URL = "https://the-internet.herokuapp.com/drag_and_drop";
    protected static final String LAMBDATEST_URL = "https://www.lambdatest.com/";
    protected static final String LAMBDATEST_SELENIUM_PLAYGROUND = "https://www.lambdatest.com/selenium-playground/";
    protected static final String LAMBDATEST_RADIO_BUTTONS_URL = "https://www.lambdatest.com/selenium-playground/radiobutton-demo";
    protected static final String LAMBDATEST_CHECKBOXES_URL = "https://www.lambdatest.com/selenium-playground/checkbox-demo";
    protected static final String LAMBDATEST_SELECT_DROPDOWN_URL = "https://www.lambdatest.com/selenium-playground/select-dropdown-demo";
    protected static final String LAMBDATEST_IFRAME_URL = "https://www.lambdatest.com/selenium-playground/iframe-demo/";
    protected static final String LAMBDATEST_NESTED_FRAMES_URL = "https://www.lambdatest.com/selenium-playground/nested-frames/";
    protected static final String LAMBDATEST_INPUT_FORM_URL = "https://www.lambdatest.com/selenium-playground/input-form-demo";
    protected static final String RAHUL_SHETTY_ACADEMY_LOCATORS_PRACTICE = "https://rahulshettyacademy.com/locatorspractice/";
    protected static final String RAHUL_SHETTY_ACADEMY_DROPDOWN_PRACTICE = "https://rahulshettyacademy.com/dropdownsPractise/";

    @BeforeSuite
    public void baseSetup() {
        logger = LogManager.getLogger(this.getClass());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    public void wait(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch(InterruptedException interruptedException) {
            logger.error(interruptedException.getMessage());
        }
    }

    public void waitForElementToBeClickable(String xpathLocator) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocator)));
    }

    public void waitForElementToBeVisible(String xpathLocator) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
    }

    public void takeScreenshotOfElement(String xpathLocator, String screenshotName) {
        WebElement element = driver.findElement(By.xpath(xpathLocator));
        File file = element.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/target/" + screenshotName + ".png"));
        } catch (IOException exception) {
            logger.error(exception.getMessage());
        }
    }
}
