package learning.selenium.tutorials.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrameTest extends Utilities {
    private WebElement iframe;
    private WebElement contentInsideBox;

    @BeforeClass
    private void openBaseUri() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        iframe = driver.findElement(By.cssSelector("#mce_0_ifr"));
    }

    // Using Index
    @Test(priority = 1)
    public void iframeByIndex() {
        driver.switchTo().frame(0);
        contentInsideBox = driver.findElement(By.cssSelector("#tinymce>p"));
        Assert.assertEquals(contentInsideBox.getText(), "Your content goes here.");
        driver.switchTo().defaultContent();
    }

    // Using Name or ID
    @Test(priority = 2)
    public void iframeByNameOrId() {
        driver.switchTo().frame("mce_0_ifr");
        contentInsideBox = driver.findElement(By.cssSelector("#tinymce>p"));
        Assert.assertEquals(contentInsideBox.getText(), "Your content goes here.");
        driver.switchTo().defaultContent();
    }

    // Using Element
    @Test(priority = 3)
    public void iframeByElement() {
        driver.switchTo().frame(iframe);
        contentInsideBox = driver.findElement(By.cssSelector("#tinymce>p"));
        Assert.assertEquals(contentInsideBox.getText(), "Your content goes here.");
    }
}
