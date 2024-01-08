package learning.cucumberselenium.nopcommerce.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import learning.cucumberselenium.general.setup.Constants;
import learning.cucumberselenium.general.setup.drivers.DriverManager;
import learning.cucumberselenium.general.utilities.PropertiesReader;
import lombok.Getter;
import lombok.Setter;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HooksNOPCommerceSelenium {
    public static SoftAssertions softAssertions;
    public static WebDriver driver;

    @Getter @Setter
    private static Scenario currentScenario;

    @Before
    public void before(Scenario scenario) {
        softAssertions = new SoftAssertions();

        DriverManager.setDriver();
        driver = DriverManager.tlDriver.get();

        setCurrentScenario(scenario);
        PropertiesReader.readProperties();
    }

    @After
    public void after(Scenario scenario) {
        if(Constants.isCaptureScreenshotsForFailedScenarios()) {
            if(scenario.isFailed()) {
                takeScreenshot(scenario);
            }
        } else if(Constants.isCaptureScreenshots()) {
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
