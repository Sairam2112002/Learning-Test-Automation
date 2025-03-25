package learning.uitesting.selenium.ai_synchronization;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest extends SeleniumBaseTest {
    public FluentWaitTest() {
        xpathLocators.put("START_BUTTON", "//div[@id='start']/button");
        xpathLocators.put("HIDDEN_ELEMENT", "//div[@id='finish']");
    }

    /*
     * Fluent Wait:
     *
     * Fluent wait specifies the maximum amount of time for WebDriver to wait for a certain condition to occur,
     * as well as the frequency with which to check the condition.
     *
     * Furthermore, the user may configure the wait to ignore specific types of exceptions whilst waiting.
     *
     * Before Selenium 3.6.0, "WebDriverWait" was a standalone class that only worked with "ExpectedConditions"
     *
     * From Selenium 3.6.0, "WebDriverWait" is made a child of "FluentWait",
     *     All features of "FluentWait" (such as custom polling intervals, ignoring exceptions, etc.) inherited by "WebDriverWait".
     *     Once "FluentWait" became the base class for "WebDriverWait", all Selenium-specific functionalities, such as "ExpectedConditions",
     *     became compatible with "FluentWait" indirectly.
     */
    @Test(priority = 1)
    public void fluentWaitTest() {
        driver.get(HEROKU_DYNAMIC_LOADING_HIDDEN_ELEMENT_URL);

        driver.findElement(By.xpath(xpathLocators.get("START_BUTTON"))).click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocators.get("HIDDEN_ELEMENT"))));
        logger.info(driver.findElement(By.xpath(xpathLocators.get("HIDDEN_ELEMENT"))).getText());
    }

    /*
     * In earlier versions of Selenium (before 3.6.0), using "ExpectedConditions" is not allowed for "FluentWait" class,
     * "ExpectedConditions" was tightly coupled with "WebDriverWait" class.
     *
     * So, FluentWait was used with custom logic implemented using Function interface inside the until() method.
     */
    @Test(priority = 2)
    public void customFluentWaitToWaitForElementToBeDisplayedUsingLambda() {
        driver.get(HEROKU_DYNAMIC_LOADING_HIDDEN_ELEMENT_URL);

        driver.findElement(By.xpath(xpathLocators.get("START_BUTTON"))).click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement element = fluentWait.until(driver -> {
            WebElement hiddenElement = driver.findElement(By.xpath(xpathLocators.get("HIDDEN_ELEMENT")));

            if(hiddenElement.isDisplayed()) {
                return hiddenElement;
            } else {
                return null;
            }
        });

        logger.info(element.getText());
    }

    @Test(priority = 3)
    public void customFluentWaitToWaitForElementToBeDisplayedUsingFunction() {
        driver.get(HEROKU_DYNAMIC_LOADING_HIDDEN_ELEMENT_URL);

        driver.findElement(By.xpath(xpathLocators.get("START_BUTTON"))).click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement element = fluentWait.until(new Function<>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                WebElement hiddenElement = driver.findElement(By.xpath(xpathLocators.get("HIDDEN_ELEMENT")));

                if(hiddenElement.isDisplayed()) {
                    return hiddenElement;
                } else {
                    return null;
                }
            }
        });

        logger.info(element.getText());
    }
}
