package learning.uitesting.selenium.generalactions.browserdrivercreation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DriverCreationBaseTest {
    protected static WebDriver driver;

    protected Logger logger = LogManager.getLogger(this.getClass());

    protected void testDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://www.nopcommerce.com/en/demo");

        By getStartedButton = By.xpath("(//a[contains(text(), 'Get started')])[1]");
        By getStartedHeader1 = By.xpath("//div[@class='getstarted-install']/h3");
        By getStartedHeader2 = By.xpath("//div[@class='getstarted-experts']/h3");

        driver.findElement(getStartedButton).click();

        logger.info(driver.findElement(getStartedHeader1).getText());
        logger.info(driver.findElement(getStartedHeader2).getText());

        driver.quit();
    }
}
