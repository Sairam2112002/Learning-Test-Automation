package learning.cucumberSelenium.projects.bookstore.stepdefsUserValidation;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static learning.cucumberSelenium.bookstore.APIConstants.*;

public class CreatingUserStepdefs {
    private final ContainerUser container;

    public CreatingUserStepdefs(ContainerUser container) {
        this.container = container;
    }

    // Scenario Outline: creating an user via an api call
    @Given("user sets the base uri for account creation")
    public void userSetsTheBaseUriForAccountCreation() {
        baseURI = USER_CREATION_URI;
    }

    @When("user sends post request with required details")
    public void userSendsPostRequestWithRequiredDetails(DataTable dataTable) {
        String username = dataTable.row(0).get(0);
        String password= dataTable.row(0).get(1);
        JSONObject userBody = new JSONObject();
        userBody.put("userName", username);
        userBody.put("password", password);

        ContainerUser.response =  given()
                .contentType("application/json")
                .body(userBody.toString())
                .when()
                .post();

        storeLoginCredentials(username, password);
    }

    @Then("validate that the response code is {int}")
    public void validateThatTheResponseCodeIs(int expectedStatusCode) {
        Assert.assertEquals(ContainerUser.response.getStatusCode(), expectedStatusCode);
    }

    @And("validate the username")
    public void validateTheUsername(DataTable dataTable) {
        String expectedUserName = dataTable.row(0).get(0);
        Assert.assertEquals(ContainerUser.response.jsonPath().getString("username"), expectedUserName);
    }

    private void storeLoginCredentials(String userName, String password) {
        ContainerUser.createdUsername = userName;
        ContainerUser.createdPassword = password;
    }
}
