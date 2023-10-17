package learning.selenium.tutorials.basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertsTest extends Utilities {
    @BeforeClass
    private void openBaseUri() {
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void alert() {
        WebElement alertButton = driver.findElement(By.cssSelector("input[value='Alert']"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am alert");
        alert.accept();
    }

    @Test(priority = 2)
    public void confirmation() {
        WebElement confirmationBox = driver.findElement(By.cssSelector("input[value='Confirmation Box']"));
        confirmationBox.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am confirm");
        alert.accept();
    }

    @Test(priority = 3)
    public void prompt() {
        WebElement prompt = driver.findElement(By.cssSelector("input[value='Prompt']"));
        prompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hi, I am Sai Ram");
        Assert.assertEquals(alert.getText(), "I am prompt");
        alert.dismiss();
    }
}
