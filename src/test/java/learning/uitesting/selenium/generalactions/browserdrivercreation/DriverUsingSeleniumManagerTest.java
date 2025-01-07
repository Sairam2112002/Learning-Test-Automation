package learning.uitesting.selenium.generalactions.browserdrivercreation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverUsingSeleniumManagerTest extends DriverCreationBaseTest {
    @Test(priority = 1)
    public void chromeDriver() {
        driver = new ChromeDriver();
        testDriver(driver);
    }

    @Test(priority = 2)
    public void firefoxDriver() {
        driver = new FirefoxDriver();
        testDriver(driver);
    }

    @Test(priority = 3)
    public void edgeDriver() {
        driver = new EdgeDriver();
        testDriver(driver);
    }
}
