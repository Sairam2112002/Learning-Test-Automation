package learning.cucumberselenium.general.setup;

import io.cucumber.java.Scenario;
import learning.cucumberselenium.general.setup.drivers.DriverManager;
import learning.cucumberselenium.general.utilities.PropertiesReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static learning.cucumberselenium.general.setup.Constants.*;

public class HooksMethods {
    public void readProperties() {
        PropertiesReader.readProperties();
    }

    public WebDriver getWebDriver() {
        DriverManager.setDriver(isHeadless());
        return DriverManager.tlDriver.get();
    }

    public void takeScreenshot(Scenario scenario, WebDriver driver) {
        if(isCaptureScreenshotsForFailedScenarios()) {
            if(scenario.isFailed()) {
                attachScreenshot(scenario, driver);
            }
        } else if(isCaptureScreenshots()) {
            attachScreenshot(scenario, driver);
        }
    }

    private void attachScreenshot(Scenario scenario, WebDriver driver) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }
}
