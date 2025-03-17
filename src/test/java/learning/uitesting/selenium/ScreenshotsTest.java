package learning.uitesting.selenium;

import learning.uitesting.selenium.utilities.SeleniumBaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ScreenshotsTest extends SeleniumBaseTest {
    @Test(priority = 1)
    public void takeScreenshot() {
        driver.get(LAMBDATEST_SELENIUM_PLAYGROUND);

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/target/screenshot.png"));
        } catch (IOException exception) {
            logger.error(Arrays.toString(exception.getStackTrace()));
        }
    }

    @Test(priority = 2)
    public void takeScreenshotOfSpecificElement() {
        driver.get(LAMBDATEST_SELENIUM_PLAYGROUND);

        WebElement lambdatestLogoImage = driver.findElement(By.xpath("//header[@id='header']/nav/div/div/div/div/div/a/img"));

        TakesScreenshot screenshot = (TakesScreenshot) lambdatestLogoImage;
        File file = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/target/elementScreenshot.png"));
        } catch (IOException exception) {
            logger.error(Arrays.toString(exception.getStackTrace()));
        }
    }
}
