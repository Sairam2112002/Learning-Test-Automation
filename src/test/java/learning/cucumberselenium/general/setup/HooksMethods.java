package learning.cucumberselenium.general.setup;

import io.cucumber.java.Scenario;
import learning.cucumberselenium.general.setup.drivers.DriverManager;
import learning.cucumberselenium.general.utilities.PropertiesReader;
import lombok.Getter;
import lombok.Setter;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static learning.cucumberselenium.general.setup.Constants.*;

public class HooksMethods {
    public static SoftAssertions softAssertions;
    public static WebDriver driver;

    @Getter @Setter
    private static Scenario currentScenario;

    public void beforeMethod(Scenario scenario) {
        PropertiesReader.readProperties();
        softAssertions = new SoftAssertions();

        DriverManager.setDriver(isHeadless());
        driver = DriverManager.tlDriver.get();

        setCurrentScenario(scenario);
    }

    public void afterMethod(Scenario scenario) {
        if(isCaptureScreenshotsForFailedScenarios()) {
            if(scenario.isFailed()) {
                takeScreenshot(scenario);
            }
        } else if(isCaptureScreenshots()) {
            takeScreenshot(scenario);
        }

        driver.quit();
        softAssertions.assertAll();
    }

    private void takeScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }
}
