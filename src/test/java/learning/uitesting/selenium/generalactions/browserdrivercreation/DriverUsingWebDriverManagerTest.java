package learning.uitesting.selenium.generalactions.browserdrivercreation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverUsingWebDriverManagerTest extends DriverCreationBaseTest {
    @Test(priority = 1)
    public void chromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        testDriver(driver);
    }

    @Test(priority = 2)
    public void firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        testDriver(driver);
    }

    @Test(priority = 3)
    public void edgeDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        testDriver(driver);
    }
}
