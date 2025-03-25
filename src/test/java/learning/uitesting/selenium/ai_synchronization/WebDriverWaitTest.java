package learning.uitesting.selenium.ai_synchronization;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebDriverWaitTest extends SeleniumBaseTest {
    public WebDriverWaitTest() {
        xpathLocators.put("NOP_COMMERCE_TITLE", "//div[@id='ph-title']/h1");
    }

    /*
     * Explicit Wait:
     *
     * It is used to allow the WebDriver to wait for a specific condition to occur before proceeding with the next step in the code.
     *
     * Unlike Implicit waits, which apply globally, explicit waits are applied only to specific elements or conditions,
     * making them more flexible and precise.
     *
     * In order to declare explicit wait, one has to use "ExpectedConditions".
     *
     * By using explicit wait, the driver will repeatedly poll for the condition specified until one of these happens:
     *     The condition is met (test passes), or
     *     The specified timeout duration is reached, in which case a TimeoutException is thrown.
     *
     * The polling interval for an explicit wait is by default "500 ms".
     *
     * Polling interval can be modified and exceptions to ignore can be specified for WebDriverWait as well since
     * "WebDriverWait" class extends "FluentWait" class.
     */
    @Test(priority = 1)
    public void explicitWaitTest() {
        driver.get(NOP_COMMERCE_URL);

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocators.get("NOP_COMMERCE_TITLE"))));

        logger.info(driver.findElement(By.xpath(xpathLocators.get("NOP_COMMERCE_TITLE"))).getText());
    }

    @Test(priority = 2)
    public void explicitWaitWithPollingAndIgnoringExceptions() {
        driver.get(NOP_COMMERCE_URL);

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocators.get("NOP_COMMERCE_TITLE"))));
        logger.info(driver.findElement(By.xpath(xpathLocators.get("NOP_COMMERCE_TITLE"))).getText());
    }
}
