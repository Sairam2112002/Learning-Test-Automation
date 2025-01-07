package learning.uitesting.selenium.generalactions.browserdrivercreation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import static learning.utilities.constants.BrowserBinariesAndDriversPaths.*;

public class BrowserDriverUsingExternalDriverTest {
    private static final Logger LOGGER = LogManager.getLogger(BrowserDriverUsingExternalDriverTest.class);
    private static WebDriver driver;

    private void testDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://www.nopcommerce.com/en/demo");

        By getStartedButton = By.xpath("(//a[contains(text(), 'Get started')])[1]");
        By getStartedHeader1 = By.xpath("//div[@class='getstarted-install']/h3");
        By getStartedHeader2 = By.xpath("//div[@class='getstarted-experts']/h3");

        driver.findElement(getStartedButton).click();

        LOGGER.info(driver.findElement(getStartedHeader1).getText());
        LOGGER.info(driver.findElement(getStartedHeader2).getText());

        driver.quit();
    }

    @Test(priority = 1)
    public void chromeDriverWithoutBinary(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        testDriver(driver);
    }

    @Test(priority = 2)
    public void firefoxDriverWithoutBinary() {
        System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
        driver = new FirefoxDriver();
        testDriver((driver));
    }

    @Test(priority = 3)
    public void edgeDriverWithoutBinary() {
        System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
        driver = new EdgeDriver();
        testDriver(driver);
    }

    @Test(priority = 4)
    public void chromeDriverWithBinary() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(CHROME_BINARY_PATH);
        driver = new ChromeDriver();
        testDriver(driver);
    }
}
