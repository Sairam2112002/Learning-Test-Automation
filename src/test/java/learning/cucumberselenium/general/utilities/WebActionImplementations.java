package learning.cucumberselenium.general.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebActionImplementations {
    private Actions actions;
    private List<String> windowHandles;
    private WebDriverWait wait;

    public void openUrl(WebDriver driver, String url) {
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void scrollToElement(WebDriver driver, WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void openLinkInNewTab(WebDriver driver, WebElement element) {
        actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
    }

    public void switchToNewlyOpenedTab(WebDriver driver) {
        windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
    }

    public void hoverOnElement(WebDriver driver, WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void waitForElementToBeVisible(WebDriver driver, WebElement element, long timeOutInSeconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
