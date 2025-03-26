package learning.uitesting.selenium.ak_window_handling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class WindowHandlingBaseTest {
    protected static WebDriver driver;
    protected Logger logger;
    protected final HashMap<String, String> xpathLocators = new HashMap<>();

    protected static final String LAMBDATEST_LOGIN_PAGE_URL = "https://accounts.lambdatest.com/login";
    protected static final String LAMBDATEST_WINDOW_POPUP_MODAL_URL = "https://www.lambdatest.com/selenium-playground/window-popup-modal-demo";

    @BeforeClass
    public void setLogger() {
        logger = LogManager.getLogger(this.getClass());
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
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
}
