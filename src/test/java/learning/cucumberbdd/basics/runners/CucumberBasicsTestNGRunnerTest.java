package learning.cucumberbdd.basics.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"learning/cucumberbdd/basics/stepdefinitions"},
        features = {"src/test/resources/features/basics"},
        tags = "@Scenario or @ScenarioOutline and not @Rule"
)
public class CucumberBasicsTestNGRunnerTest extends AbstractTestNGCucumberTests {
}
