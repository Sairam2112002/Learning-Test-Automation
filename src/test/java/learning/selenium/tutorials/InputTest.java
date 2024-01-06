package learning.selenium.tutorials;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class InputTest extends SeleniumBase {
    private final By pageTitle = By.cssSelector("#content>div>div>h3");
    private final By inputElement = By.cssSelector("input");

    @Test
    public void inputTest() {
        openBaseUri("https://the-internet.herokuapp.com/inputs");
        softAssertions.assertThat(driver.findElement(pageTitle).getText()).isEqualTo("Inputs");

        driver.findElement(inputElement).sendKeys("100");
        softAssertions.assertThat(driver.findElement(inputElement).getAttribute("value")).isEqualTo("100");

        softAssertions.assertAll();
    }
}
