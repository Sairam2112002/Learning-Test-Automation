package learning.uitesting.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends SeleniumBaseTest {
    private Alert alert;

    @Test
    public void alertsAndPopups() {
        driver.get(HEROKU_JS_ALERTS);

        // Simple Alert
        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        simpleAlertButton.click();
        alert = driver.switchTo().alert();
        alert.accept();
        logger.info(driver.findElement(By.xpath("//p[@id='result']")).getText());

        // Confirm Alert
        WebElement confirmAlertButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));

        confirmAlertButton.click();
        alert = driver.switchTo().alert();
        alert.accept();
        logger.info(driver.findElement(By.xpath("//p[@id='result']")).getText());

        confirmAlertButton.click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        logger.info(driver.findElement(By.xpath("//p[@id='result']")).getText());

        // Prompt Alert
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));

        promptAlertButton.click();
        alert = driver.switchTo().alert();
        alert.sendKeys("This is sample text");
        alert.accept();
        logger.info(driver.findElement(By.xpath("//p[@id='result']")).getText());

        promptAlertButton.click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        logger.info(driver.findElement(By.xpath("//p[@id='result']")).getText());
    }
}
