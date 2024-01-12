package learning.selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MultipleWindowsTest extends SeleniumBase {
    private final By pageTitle = By.cssSelector("#content>div>h3");
    private final By clickHereLink = By.cssSelector(".example>a");
    private final By newWindowTitle = By.cssSelector(".example>h3");

    @Test
    public void multipleWindowsTest() {
        openBaseUri("https://the-internet.herokuapp.com/windows");
        softAssertions.assertThat(driver.findElement(pageTitle).getText()).isEqualTo("Opening a new window");

        driver.findElement(clickHereLink).click();
        windowHandles = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windowHandles.get(0));
        softAssertions.assertThat(driver.findElement(pageTitle).getText()).isEqualTo("Opening a new window");

        driver.switchTo().window(windowHandles.get(1));
        softAssertions.assertThat(driver.findElement(newWindowTitle).getText()).isEqualTo("New Window");

        softAssertions.assertAll();
    }
}
