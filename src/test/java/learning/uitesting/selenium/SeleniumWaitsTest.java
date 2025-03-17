package learning.uitesting.selenium;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWaitsTest extends SeleniumBaseTest {
    private WebDriverWait explicitWait;
    private FluentWait<WebDriver> fluentWait;

    private static final String GOOGLE_SEARCH_BOX = "//textarea[@aria-label='Search']";
    private static final String NOP_COMMERCE_TITLE = "//div[@id='ph-title']/h1";

    @Test(priority = 1)
    public void implicitWaitTest() {
        driver.get(GOOGLE_SEARCH_URL);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement searchBox = driver.findElement(By.xpath(GOOGLE_SEARCH_BOX));
        searchBox.sendKeys("Selenium");
        searchBox.sendKeys(Keys.RETURN);

        logger.info(driver.getTitle());
    }

    @Test(priority = 2)
    public void explicitWaitTest() {
        driver.get(NOP_COMMERCE_URL);

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NOP_COMMERCE_TITLE)));

        logger.info(driver.findElement(By.xpath(NOP_COMMERCE_TITLE)).getText());
    }

    @Test(priority = 3)
    public void fluentWaitTest() {
        driver.get(NOP_COMMERCE_URL);

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(StaleElementReferenceException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NOP_COMMERCE_TITLE)));
        logger.info(driver.findElement(By.xpath(NOP_COMMERCE_TITLE)).getText());
    }
}
