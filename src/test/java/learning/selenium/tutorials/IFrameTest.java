package learning.selenium.tutorials;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IFrameTest extends SeleniumBase {
    private final By pageTitle = By.cssSelector("#content>div>h3");
    private final By iFrame = By.cssSelector("#mce_0_ifr");
    private final By paragraph = By.cssSelector("#tinymce>p");

    @Test
    public void iFrameTest() {
        openBaseUri("https://the-internet.herokuapp.com/iframe");
        softAssertions.assertThat(driver.findElement(pageTitle).getText()).isEqualTo("An iFrame containing the TinyMCE WYSIWYG Editor");

        driver.switchTo().frame(driver.findElement(iFrame));
        softAssertions.assertThat(driver.findElement(paragraph).getText()).isEqualTo("Your content goes here.");

        driver.switchTo().defaultContent();
        softAssertions.assertThat(driver.findElement(pageTitle).getText()).isEqualTo("An iFrame containing the TinyMCE WYSIWYG Editor");

        softAssertions.assertAll();
    }
}
