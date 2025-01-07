package learning.uitesting.selenium.generalactions.browserdrivercreation;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import static learning.utilities.constants.BrowserBinariesAndDriversPaths.*;

public class DriverUsingExternalDriverTest extends DriverCreationBaseTest {
    @Test(priority = 1)
    public void chromeDriver(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        testDriver(driver);
    }

    @Test(priority = 2)
    public void firefoxDriver() {
        System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
        driver = new FirefoxDriver();
        testDriver((driver));
    }

    @Test(priority = 3)
    public void edgeDriver() {
        System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
        driver = new EdgeDriver();
        testDriver(driver);
    }

    @Test(priority = 4)
    public void chromeDriverWithChromeBinary() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(CHROME_BINARY_PATH);
        driver = new ChromeDriver();
        testDriver(driver);
    }
}
