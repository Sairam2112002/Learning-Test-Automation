package learning.selenium.tutorials.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBoxTest extends Utilities {
    @BeforeClass
    private void openBaseUri() {
        driver.get("https://artoftesting.com/samplesiteforselenium");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void radioButton() {
        WebElement radioButton = driver.findElement(By.cssSelector("#male"));
        radioButton.click();
        Assert.assertTrue(radioButton.isSelected());
    }

    @Test(priority = 2)
    public void checkbox() {
        WebElement checkbox = driver.findElement(By.cssSelector("input[value='Automation']"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
    }
}
