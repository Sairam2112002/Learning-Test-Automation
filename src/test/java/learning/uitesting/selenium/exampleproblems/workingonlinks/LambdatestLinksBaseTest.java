package learning.uitesting.selenium.exampleproblems.workingonlinks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LambdatestLinksBaseTest {
    protected WebDriver driver;
    protected Logger logger;

    private static final String LAMBDATEST_SELENIUM_PLAY_GROUND_URL = "https://www.lambdatest.com/selenium-playground/";

    @BeforeClass
    public void beforeClass() {
        logger = LogManager.getLogger(this.getClass());
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(LAMBDATEST_SELENIUM_PLAY_GROUND_URL);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
