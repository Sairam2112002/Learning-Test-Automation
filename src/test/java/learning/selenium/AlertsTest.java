package learning.selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AlertsTest extends SeleniumBase {
    private final By pageTitle = By.cssSelector("#content>div>h3");
    private final By jsAlert = By.xpath("//div[@id='content']/div[@class='example']/ul/li[1]/button");
    private final By jsConfirm = By.xpath("//div[@id='content']/div[@class='example']/ul/li[2]/button");
    private final By jsPrompt = By.xpath("//div[@id='content']/div[@class='example']/ul/li[3]/button");

    @Test
    public void alertsTest() {
        openBaseUri("https://the-internet.herokuapp.com/javascript_alerts");
        softAssertions.assertThat(driver.findElement(pageTitle).getText()).isEqualTo("JavaScript Alerts");

        driver.findElement(jsAlert).click();
        alert = driver.switchTo().alert();
        softAssertions.assertThat(alert.getText()).isEqualTo("I am a JS Alert");
        alert.accept();

        driver.findElement(jsConfirm).click();
        alert = driver.switchTo().alert();
        softAssertions.assertThat(alert.getText()).isEqualTo("I am a JS Confirm");
        alert.dismiss();

        driver.findElement(jsPrompt).click();
        alert = driver.switchTo().alert();
        alert.sendKeys("sample text");
        softAssertions.assertThat(alert.getText()).isEqualTo("I am a JS prompt");
        alert.dismiss();

        softAssertions.assertAll();
    }
}
