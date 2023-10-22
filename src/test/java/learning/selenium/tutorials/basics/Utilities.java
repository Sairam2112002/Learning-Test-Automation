package learning.selenium.tutorials.basics;

import learning.selenium.exceptions.DriverNotFoundException;
import learning.utilities.driverfactoryselenium.Driver;
import learning.utilities.driverfactoryselenium.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class Utilities {
    protected static WebDriver driver;

    @BeforeClass
    public void setUp() throws IOException, DriverNotFoundException {
        Driver browserType = DriverFactory.createDriver();
        driver = browserType.getDriver();
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}
