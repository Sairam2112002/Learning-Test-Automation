package learning.selenium.tutorials.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultipleWindowsTest extends Utilities {
    private List<String> handles;

    @BeforeClass
    private void openBaseUri() {
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void navigateToNewWindow() {
        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();

        // To get the Window Handles
        Set<String> handlesSet = driver.getWindowHandles();
        handles = new ArrayList<>(handlesSet);
        driver.switchTo().window(handles.get(1));

        WebElement newWindowContent = driver.findElement(By.cssSelector(".example>h3"));
        Assert.assertEquals(newWindowContent.getText(), "New Window");
    }

    @Test(priority = 2)
    public void navigateBack() {
        driver.switchTo().window(handles.get(0));
        WebElement oldWindowContent = driver.findElement(By.cssSelector(".example>h3"));
        Assert.assertEquals(oldWindowContent.getText(), "Opening a new window");
    }
}
