package learning.cucumberbdd.basics.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;

import java.util.List;
import java.util.Map;

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

    // Data Table examples
    @Given("Data table as list of list of strings")
    public void dataTableAsListOfListOfStrings(List<List<String>> listOfListOfStrings) {
        for(List<String> stringList: listOfListOfStrings) {
            for(String string: stringList) {
                System.out.print(string + ", ");
            }
            System.out.println();
        }
    }

    @Given("Data table as list of maps")
    public void dataTableAsListOfMaps(List<Map<String, String>> listOfMaps) {
        for(Map<String, String> map: listOfMaps) {
            for(String key: map.keySet()) {
                System.out.print(key + ": " + map.get(key) + ", ");
            }
            System.out.println();
        }
    }

    @Given("Data table as map")
    public void dataTableAsMap(Map<String, String> map) {
        for(String key: map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    @Given("Data table as map of lists")
    public void dataTableAsMapOfLists(Map<String, List<String>> mapOfLists) {
        for(String key: mapOfLists.keySet()) {
            System.out.print(key + ": ");
            for(String string: mapOfLists.get(key)) {
                System.out.print(string + ", ");
            }
            System.out.println();
        }
    }

    @Given("Data table as map of maps")
    public void dataTableAsMapOfMaps(Map<String, Map<String, String>> mapOfMaps) {
        for(String key1: mapOfMaps.keySet()) {
            System.out.print(key1 + ": ");
            for(String key2: mapOfMaps.get(key1).keySet()) {
                System.out.print(key2 + ": " + mapOfMaps.get(key1).get(key2) + ", ");
            }
            System.out.println();
        }
    }
}
