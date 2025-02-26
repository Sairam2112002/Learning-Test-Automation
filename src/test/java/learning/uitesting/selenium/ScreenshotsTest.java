package learning.uitesting.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ScreenshotsTest extends SeleniumBaseTest {
    @Test
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
}
