package learning.uitesting.selenium.ah_javascript_alerts;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends SeleniumBaseTest {
    private Alert alert;

    public JavaScriptAlertsTest() {
        xpathLocators.put("SIMPLE_ALERT_BUTTON", "//button[@onclick='jsAlert()']");
        xpathLocators.put("CONFIRM_ALERT_BUTTON", "//button[@onclick='jsConfirm()']");
        xpathLocators.put("PROMPT_ALERT_BUTTON", "//button[@onclick='jsPrompt()']");
        xpathLocators.put("ALERT_RESULT", "//p[@id='result']");
    }

    @Test(priority = 1)
    public void setUp() {
        driver.get(HEROKU_JS_ALERTS_URL);
    }

    @Test(priority = 2)
    public void simpleAlert() {
        WebElement simpleAlertButton = driver.findElement(By.xpath(xpathLocators.get("SIMPLE_ALERT_BUTTON")));
        simpleAlertButton.click();
        alert = driver.switchTo().alert();
        alert.accept();
        logger.info(driver.findElement(By.xpath(xpathLocators.get("ALERT_RESULT"))).getText());
    }

    @Test(priority = 3)
    public void confirmAlert() {
        WebElement confirmAlertButton = driver.findElement(By.xpath(xpathLocators.get("CONFIRM_ALERT_BUTTON")));

        confirmAlertButton.click();
        alert = driver.switchTo().alert();
        alert.accept();
        logger.info(driver.findElement(By.xpath(xpathLocators.get("ALERT_RESULT"))).getText());

        confirmAlertButton.click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        logger.info(driver.findElement(By.xpath(xpathLocators.get("ALERT_RESULT"))).getText());
    }

    @Test(priority = 4)
    public void promptAlert() {
        WebElement promptAlertButton = driver.findElement(By.xpath(xpathLocators.get("PROMPT_ALERT_BUTTON")));

        promptAlertButton.click();
        alert = driver.switchTo().alert();
        alert.sendKeys("This is sample text");
        alert.accept();
        logger.info(driver.findElement(By.xpath(xpathLocators.get("ALERT_RESULT"))).getText());

        promptAlertButton.click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        logger.info(driver.findElement(By.xpath(xpathLocators.get("ALERT_RESULT"))).getText());
    }
}
