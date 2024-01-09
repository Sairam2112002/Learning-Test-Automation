package learning.cucumberselenium.nopcommerce.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import learning.cucumberselenium.general.setup.HooksMethods;
import learning.cucumberselenium.nopcommerce.pages.PageContext;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class HooksNOPCommerceSelenium extends HooksMethods {
    public static SoftAssertions softAssertions;
    public static WebDriver driver;
    public static Scenario currentScenario;

    @Before
    public void before(Scenario scenario) {
        readProperties();
        driver = getWebDriver();
        driver.manage().window().maximize();
        PageContext.initContext(driver);

        softAssertions = new SoftAssertions();
        currentScenario = scenario;
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void after(Scenario scenario) {
        takeScreenshot(scenario, driver);

        driver.quit();
        softAssertions.assertAll();
    }
}
