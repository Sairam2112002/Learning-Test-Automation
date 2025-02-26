package learning.uitesting.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SeleniumBaseTest {
    protected static WebDriver driver;
    protected Logger logger;

    protected static final String NOP_COMMERCE_URL = "https://www.nopcommerce.com/en/demo";
    protected static final String GOOGLE_SEARCH_URL = "https://www.google.com/";
    protected static final String SELENIUM_HOME_PAGE_URL = "https://www.selenium.dev/";
    protected static final String MDN_WEB_DOCS_URL = "https://developer.mozilla.org/en-US/";
    protected static final String EXAMPLE_URL = "http://example.com";
    protected static final String WIKIPEDIA_URL = "https://www.wikipedia.org/";
    protected static final String OPEN_CART_URL = "https://naveenautomationlabs.com/opencart/";
    protected static final String HEROKU_CHECKBOXES_URL = "https://the-internet.herokuapp.com/checkboxes";
    protected static final String HEROKU_JS_ALERTS_URL = "https://the-internet.herokuapp.com/javascript_alerts";
    protected static final String LAMBDATEST_RADIO_BUTTONS_URL = "https://www.lambdatest.com/selenium-playground/radiobutton-demo";
    protected static final String LAMBDATEST_SELECT_DROPDOWN_URL = "https://www.lambdatest.com/selenium-playground/select-dropdown-demo";
    protected static final String LAMBDATEST_IFRAME_URL = "https://www.lambdatest.com/selenium-playground/iframe-demo/";
    protected static final String LAMBDATEST_NESTED_FRAMES_URL = "https://www.lambdatest.com/selenium-playground/nested-frames/";

    @BeforeClass
    public void baseSetup() {
        logger = LogManager.getLogger(this.getClass());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
