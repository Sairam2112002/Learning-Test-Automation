package learning.cucumberPlaywright.fillingform.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FillingFormStepdefs {
    private final ContainerForm container;

    public FillingFormStepdefs(ContainerForm container) {
        this.container = container;
    }

    @Given("user opens the survey form website")
    public void userOpensTheSurveyFormWebsite() {
        ContainerForm.formPage.openFormPage();
    }

    @When("user enters all the required details")
    public void userEntersAllTheRequiredDetails() {
        ContainerForm.formPage = ContainerForm.formPage.enterDetails();
    }

    @Then("verify the entered name is {string}")
    public void verifyTheEnteredName(String expectedName) {
        ContainerForm.formPage.verifyName(expectedName);
    }

    @And("verify the entered email is {string}")
    public void verifyTheEnteredEmail(String expectedEmail) {
        ContainerForm.formPage.verifyEmail(expectedEmail);
    }

    @And("verify the entered age is {string}")
    public void verifyTheEnteredAge(String expectedAge) {
        ContainerForm.formPage.verifyAge(expectedAge);
    }

    @And("verify the selected role is {string}")
    public void verifyTheSelectedRole(String expectedRole) {
        ContainerForm.formPage.verifyRole(expectedRole);
    }

    @And("verify the checked recommendation")
    public void verifyTheCheckedRecommendation() {
        ContainerForm.formPage.verifyRecommendation();
    }

    @And("verify the selected improvements")
    public void verifyTheSelectedImprovements() {
        ContainerForm.formPage.verifyImprovements();
    }

    @And("verify the entered suggestions is {string}")
    public void verifyTheEnteredSuggestions(String expectedSuggestions) {
        ContainerForm.formPage.verifySuggestions(expectedSuggestions);
    }
}
