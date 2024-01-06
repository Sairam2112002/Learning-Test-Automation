package learning.selenium.tutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropTest extends SeleniumBase{
    private final By pageTitle = By.cssSelector("#content>div>h3");
    private final By firstBox = By.cssSelector("#column-a");
    private final By firstBoxText = By.cssSelector("#column-a>header");
    private final By secondBox = By.cssSelector("#column-b");
    private final By secondBoxText = By.cssSelector("#column-b>header");

    @Test
    public void dragAndDropTest() {
        openBaseUri("https://the-internet.herokuapp.com/drag_and_drop");
        softAssertions.assertThat(driver.findElement(pageTitle).getText()).isEqualTo("Drag and Drop");

        softAssertions.assertThat(driver.findElement(firstBoxText).getText()).isEqualTo("A");
        softAssertions.assertThat(driver.findElement(secondBoxText).getText()).isEqualTo("B");

        actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(firstBox), driver.findElement(secondBox)).perform();
        softAssertions.assertThat(driver.findElement(firstBoxText).getText()).isEqualTo("B");
        softAssertions.assertThat(driver.findElement(secondBoxText).getText()).isEqualTo("A");

        softAssertions.assertAll();
    }
}
