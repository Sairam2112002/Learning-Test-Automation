package learning.uitesting.selenium.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UtilityMethods extends SeleniumBaseTest {
    private WebDriverWait webDriverWait;

    private static final long DEFAULT_TIME_OUT_IN_SECONDS = 5;

    public void waitForElementToBeClickable(String xpathLocator) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocator)));
    }

    public void waitForElementToBeVisible(String xpathLocator) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT_IN_SECONDS));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
    }
}
