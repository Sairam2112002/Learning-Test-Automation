package learning.cucumberPlaywright.opencart.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, glue = {"learning.cucumberPlaywright.opencart.stepdefs"}, features = {"src/test/resources/features/cucumber-playwright/opencart/opencart.feature"})
public class OpencartRunner extends AbstractTestNGCucumberTests {
}
