package learning.uitesting.selenium.ai_synchronization;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

/*
 * In Selenium, wait commands are used to synchronize the execution of test scripts with the state of the web application.
 *
 * Wait Commands help ensure that the script waits for certain conditions to be met before proceeding,
 * which is crucial for dynamic web pages where elements may take time to load.
 */
public class SeleniumWaitsTest extends SeleniumBaseTest {
    public SeleniumWaitsTest() {
        xpathLocators.put("GOOGLE_SEARCH_BOX", "//textarea[@aria-label='Search']");
        xpathLocators.put("NOP_COMMERCE_TITLE", "//div[@id='ph-title']/h1");
    }

    /*
     * Implicit Wait:
     *
     * It specifies the amount of time the driver should wait when searching for an element if it is not immediately present
     * before throwing "NoSuchElementException"
     *
     * Implicit Wait setting is a Global setting and applies to all elements in the script,
     * and it remains in effect for the duration of the WebDriver instance.
     *
     * When an implicit wait is set, the WebDriver will continuously try to locate the element during the specified timeout duration.
     * If the element is not immediately found, the driver will repeatedly poll the DOM for the presence of the element until:
     *     The element is found, or
     *     The specified timeout duration is exceeded, in which case "NoSuchElementException" is thrown
     * The polling interval (how frequently Selenium reattempts to find the element) in implicit wait is fixed and is
     * "500 ms".
     */
    @Test(priority = 1)
    public void implicitWaitTest() {
        driver.get(GOOGLE_SEARCH_URL);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement searchBox = driver.findElement(By.xpath(xpathLocators.get("GOOGLE_SEARCH_BOX")));
        searchBox.sendKeys("Selenium");
        searchBox.sendKeys(Keys.RETURN);

        logger.info(driver.getTitle());
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
     */
    @Test(priority = 2)
    public void explicitWaitTest() {
        driver.get(NOP_COMMERCE_URL);

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocators.get("NOP_COMMERCE_TITLE"))));

        logger.info(driver.findElement(By.xpath(xpathLocators.get("NOP_COMMERCE_TITLE"))).getText());
    }

    /*
     * Fluent Wait:
     *
     * Fluent wait specifies the maximum amount of time for WebDriver to wait for a certain condition to occur,
     * as well as the frequency with which to check the condition.
     *
     * Furthermore, the user may configure the wait to ignore specific types of exceptions whilst waiting.
     */
    @Test(priority = 3)
    public void fluentWaitTest() {
        driver.get(NOP_COMMERCE_URL);

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(4))
                .ignoring(StaleElementReferenceException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocators.get("NOP_COMMERCE_TITLE"))));
        logger.info(driver.findElement(By.xpath(xpathLocators.get("NOP_COMMERCE_TITLE"))).getText());
    }
}
