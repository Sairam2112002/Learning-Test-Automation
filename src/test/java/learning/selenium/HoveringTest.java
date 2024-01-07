package learning.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HoveringTest extends SeleniumBase{
    private final By pageTitle = By.cssSelector("#content>div>h3");
    private final By image1 = By.xpath("//div[@id='content']/div/div[@class='figure'][1]");
    private final By image1User = By.xpath("//div[@id='content']/div/div[@class='figure'][1]/div/h5");
    private final By image2 = By.xpath("//div[@id='content']/div/div[@class='figure'][2]");
    private final By image2User = By.xpath("//div[@id='content']/div/div[@class='figure'][2]/div/h5");
    private final By image3 = By.xpath("//div[@id='content']/div/div[@class='figure'][3]");
    private final By image3User = By.xpath("//div[@id='content']/div/div[@class='figure'][3]/div/h5");

    @Test
    public void hoveringTest() {
        openBaseUri("https://the-internet.herokuapp.com/hovers");
        softAssertions.assertThat(driver.findElement(pageTitle).getText()).isEqualTo("Hovers");

        actions = new Actions(driver);

        actions.moveToElement(driver.findElement(image1)).perform();
        softAssertions.assertThat(driver.findElement(image1User).getText()).contains("user1");

        actions.moveToElement(driver.findElement(image2)).perform();
        softAssertions.assertThat(driver.findElement(image2User).getText()).contains("user2");

        actions.moveToElement(driver.findElement(image3)).perform();
        softAssertions.assertThat(driver.findElement(image3User).getText()).contains("user3");

        softAssertions.assertAll();
    }
}
