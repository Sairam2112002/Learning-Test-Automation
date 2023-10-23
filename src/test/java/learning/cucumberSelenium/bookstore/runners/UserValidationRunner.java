package learning.cucumberSelenium.bookstore.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, glue = "learning",
features = {"src/test/resources/features/cucumber-selenium/bookstoreproject/userCreation.feature"})
public class UserValidationRunner extends AbstractTestNGCucumberTests {

}
