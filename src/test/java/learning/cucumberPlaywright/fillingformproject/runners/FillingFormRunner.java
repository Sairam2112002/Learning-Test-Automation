package learning.cucumberPlaywright.fillingformproject.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, glue = {"learning"}, features = {"src/test/resources/features/cucumber-playwright/fillingformproject/fillingForm.feature"})
public class FillingFormRunner extends AbstractTestNGCucumberTests {

}
