package learning.selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NestedFramesTest extends SeleniumBase {
    private final By frameTop = By.cssSelector("frame[name='frame-top']");
    private final By frameLeft = By.cssSelector("frame[name='frame-left']");
    private final By frameLeftText = By.xpath("//body[contains(text(), 'LEFT')]");
    private final By frameMiddle = By.cssSelector("frame[name='frame-middle']");
    private final By frameMiddleText = By.cssSelector("#content");
    private final By frameRight = By.cssSelector("frame[name='frame-right']");
    private final By frameRightText = By.xpath("//body[contains(text(), 'RIGHT')]");
    private final By frameBottom = By.cssSelector("frame[name='frame-bottom']");
    private final By frameBottomText = By.xpath("//body[contains(text(), 'BOTTOM')]");

    @Test
    public void nestedFramesTest() {
        openBaseUri("https://the-internet.herokuapp.com/nested_frames");;

        driver.switchTo().frame(driver.findElement(frameTop));

        driver.switchTo().frame(driver.findElement(frameLeft));
        softAssertions.assertThat(driver.findElement(frameLeftText).getText()).isEqualTo("LEFT");

        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(frameMiddle));
        softAssertions.assertThat(driver.findElement(frameMiddleText).getText()).isEqualTo("MIDDLE");

        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(frameRight));
        softAssertions.assertThat(driver.findElement(frameRightText).getText()).isEqualTo("RIGHT");

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(frameBottom));
        softAssertions.assertThat(driver.findElement(frameBottomText).getText()).isEqualTo("BOTTOM");

        softAssertions.assertAll();
    }
}
