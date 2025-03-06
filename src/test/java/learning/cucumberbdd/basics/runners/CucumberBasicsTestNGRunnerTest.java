package learning.cucumberbdd.basics.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"learning/cucumberbdd/basics/stepdefinitions"},
        features = {"src/test/resources/features/basics"},
        tags = "@DataTable"
)
public class CucumberBasicsTestNGRunnerTest extends AbstractTestNGCucumberTests {
}
