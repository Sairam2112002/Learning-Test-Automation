package learning.cucumberbdd.basics.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberBasicsStepDefinitions {
    // Background
    @Given("User is on application landing page")
    public void userIsOnApplicationLandingPage() {
        System.out.println("User is on application landing page");
    }

    // Rules
    @Given("User is on login page")
    public void userIsOnLoginPage() {
        System.out.println("User is on login page");
    }

    @When("User enters credentials")
    public void userEntersCredentials() {
        System.out.println("User enters credentials");
    }

    @And("User clicks login")
    public void userClicksLogin() {
        System.out.println("User clicks login");
    }

    @Then("User should navigate to their landing page")
    public void userShouldNavigateToTheirLandingPage() {
        System.out.println("User navigates to their landing page");
    }

    // Scenario Outline
    @Given("there are {int} cucumbers")
    public void thereAreStartCucumbers(int start) {
        System.out.println("There are " + start + " cucumbers");
    }

    @When("I eat {int} cucumbers")
    public void iEatEatCucumbers(int eat) {
        System.out.println("I eat " + eat + " cucumbers");
    }

    @Then("I should have {int} cucumbers")
    public void iShouldHaveLeftCucumbers(int left) {
        System.out.println("I should have " + left + " cucumbers");
    }
}
