package learning.selenium.tutorials.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NestedFramesTest extends Utilities {
    @BeforeClass
    private void openBaseUri() {
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void frameTopLeft() {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement topLeftFrameBody = driver.findElement(By.cssSelector("body"));
        Assert.assertEquals(topLeftFrameBody.getText(), "LEFT");
        driver.switchTo().parentFrame();
    }

    @Test(priority = 2)
    public void frameTopMiddle() {
        driver.switchTo().frame("frame-middle");
        WebElement topLeftFrameBody = driver.findElement(By.cssSelector("body"));
        Assert.assertEquals(topLeftFrameBody.getText(), "MIDDLE");
        driver.switchTo().parentFrame();
    }

    @Test(priority = 3)
    public void frameTopRight() {
        driver.switchTo().frame("frame-right");
        WebElement topLeftFrameBody = driver.findElement(By.cssSelector("body"));
        Assert.assertEquals(topLeftFrameBody.getText(), "RIGHT");
        driver.switchTo().defaultContent();
    }

    @Test(priority = 4)
    public void frameBottom() {
        driver.switchTo().frame("frame-bottom");
        WebElement topLeftFrameBody = driver.findElement(By.cssSelector("body"));
        Assert.assertEquals(topLeftFrameBody.getText(), "BOTTOM");
    }
}
