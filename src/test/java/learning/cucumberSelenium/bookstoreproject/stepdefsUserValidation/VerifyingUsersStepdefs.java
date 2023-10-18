package learning.cucumberSelenium.bookstoreproject.stepdefsUserValidation;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class VerifyingUsersStepdefs {
    private final ContainerUser container;

    public VerifyingUsersStepdefs(ContainerUser container) {
        this.container = container;
    }

    // Scenario: validating the created user by logging in
    @Given("user opens the book store website")
    public void userOpensTheBookStoreWebsite() {
        ContainerUser.homePage.openHomePage();
    }

    @When("user enters the created details and logs in")
    public void userEntersTheCreatedDetailsAndLogsIn() {
        ContainerUser.userPage = ContainerUser.homePage.enterLogInCredentials(ContainerUser.createdUsername, ContainerUser.createdPassword);
    }

    @Then("verify the created username")
    public void verifyTheCreatedUsername() {
        Assert.assertTrue(ContainerUser.userPage.verifyUsername(ContainerUser.createdUsername));
    }

    // Scenario Outline: validating existing users via logging in
    @When("user enters the details and logs in")
    public void userEntersTheDetailsAndLogsIn(DataTable dataTable) {
        String username = dataTable.row(0).get(0);
        String password = dataTable.row(0).get(1);
        ContainerUser.userPage = ContainerUser.homePage.enterLogInCredentials(username, password);
    }

    @Then("verify the username")
    public void verifyTheUsername(DataTable dataTable) {
        String username = dataTable.row(0).get(0);
        Assert.assertTrue(ContainerUser.userPage.verifyUsername(username));
    }
}
