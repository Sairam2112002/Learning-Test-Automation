package learning.cucumberselenium.general.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WebActionImplementations {
    private Actions actions;
    private List<String> windowHandles;

    public void openUrl(WebDriver driver, String url) {
        driver.get(url);
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
}
