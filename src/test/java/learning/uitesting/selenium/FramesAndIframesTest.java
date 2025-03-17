package learning.uitesting.selenium;

import learning.uitesting.selenium.utilities.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FramesAndIframesTest extends SeleniumBaseTest {
    /*
     * Both frames and iframes can be accessed with index, name or id and web element with same methods
     *
     * switchTo().defaultContext() method is used to switch back to the main content of the webpage,
     * as any further operations might cause a NoSuchElementException
     * if they are directed at elements outside the frame/iframe context
     *
     * switchTo().parentFrame() method is used to switch to parent frame
     */

    private WebElement iframeEditorArea;

    @Test(priority = 1)
    public void iframeUsingIndexTest() {
        driver.get(LAMBDATEST_IFRAME_URL);

        driver.switchTo().frame(0);

        iframeEditorArea = driver.findElement(By.xpath("//div[@id='__next']/div/div[@class='rsw-ce']"));
        iframeEditorArea.clear();
        iframeEditorArea.sendKeys("This is an iframe test");
        logger.info(iframeEditorArea.getText());
    }

    @Test(priority = 2)
    public void iframeUsingNameOrID() {
        driver.get(LAMBDATEST_IFRAME_URL);

        driver.switchTo().frame("iFrame1");

        iframeEditorArea = driver.findElement(By.xpath("//div[@id='__next']/div/div[@class='rsw-ce']"));
        iframeEditorArea.clear();
        iframeEditorArea.sendKeys("This is an iframe test");
        logger.info(iframeEditorArea.getText());
    }

    @Test(priority = 3)
    public void iframeUsingWebElement() {
        driver.get(LAMBDATEST_IFRAME_URL);
        WebElement iframeElement = driver.findElement(By.cssSelector("iframe#iFrame1"));

        driver.switchTo().frame(iframeElement);

        iframeEditorArea = driver.findElement(By.xpath("//div[@id='__next']/div/div[@class='rsw-ce']"));
        iframeEditorArea.clear();
        iframeEditorArea.sendKeys("This is an iframe test");
        logger.info(iframeEditorArea.getText());
    }

    @Test(priority = 4)
    public void nestedFrames() {
        driver.get(LAMBDATEST_NESTED_FRAMES_URL);

        driver.switchTo().frame("frame-top");
        WebElement topFrame = driver.findElement(By.cssSelector("body > p"));
        logger.info(topFrame.getText());
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");

        driver.switchTo().frame("frame-left");
        WebElement leftFrame = driver.findElement(By.cssSelector("body > p"));
        logger.info(leftFrame.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        WebElement middleFrame = driver.findElement(By.cssSelector("body > p"));
        logger.info(middleFrame.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        WebElement rightFrame = driver.findElement(By.cssSelector("body > p"));
        logger.info(rightFrame.getText());
        driver.switchTo().defaultContent();
    }
}
