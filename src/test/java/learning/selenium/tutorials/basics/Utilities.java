package learning.selenium.tutorials.basics;

import learning.utilities.driverfactoryselenium.Driver;
import learning.utilities.driverfactoryselenium.DriverFactory;
import learning.selenium.exceptions.BrowserNotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class Utilities {
    protected static WebDriver driver;

    @BeforeClass
    public void setUp() throws BrowserNotFoundException, IOException {
        Driver browserType = DriverFactory.createDriver();
        driver = browserType.getDriver();
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}
