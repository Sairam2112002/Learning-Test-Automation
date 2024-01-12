package learning.cucumberselenium.nopcommerce.runner;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.CourgetteTestOutput;
import courgette.api.CucumberOptions;
import courgette.api.testng.TestNGCourgette;

@CourgetteOptions(
        threads = 4,
        runLevel = CourgetteRunLevel.SCENARIO,
        testOutput = CourgetteTestOutput.CONSOLE,
        rerunFailedScenarios = true,
        reportTargetDir = "target",
        reportTitle = "NOPCommerce-Selenium-TestReport",
        cucumberOptions = @CucumberOptions(
                features = {"src/test/resources/features/selenium/nopcommerce"},
                glue = {"learning/cucumberselenium/nopcommerce/stepdefinitions"},
                tags = "@LandingPage",
                plugin = {
                        "pretty",
                        "json:target/cucumber-reports/Cucumber.json",
                        "html:target/cucumber-reports/Cucumber.html",
                }
        ))
public class NOPCommerceSeleniumTestRunner extends TestNGCourgette {

}
