package learning.uitesting.selenium.generalactions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SeleniumBaseTest {
    protected WebDriver driver;
    protected Logger logger;

    @BeforeClass
    public void baseSetup() {
        driver = new ChromeDriver();
        logger = LogManager.getLogger(this.getClass());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
