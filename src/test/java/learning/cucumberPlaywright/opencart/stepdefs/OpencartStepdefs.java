package learning.cucumberPlaywright.opencart.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpencartStepdefs {
    /**
     * Scenario: user searches in the opencart website
     */
    @Given("user opens the opencart website")
    public void userOpensTheOpencartWebsite() {
        Container.homePage.openBaseUri();
    }

    @When("user enters {string} in the search bar")
    public void userEntersInTheSearchBar(String textToSearch) {
        Container.searchResultsPage = Container.homePage.search(textToSearch);
    }

    @Then("user navigates to search results page")
    public void userNavigatesToSearchResultsPage() {
        Container.searchResultsPage.printSearchResultsPageUrl();
    }

    /**
     * Scenario: user clicks on macbook pro
     */
    @When("user clicks on MacbookPro")
    public void userClicksOnMacbookPro() {
        Container.productPage = Container.searchResultsPage.clickOnMacbookPro();
    }

    @Then("user navigates to MacbookPro product page")
    public void userNavigatesToMacbookProProductPage() {
        Container.productPage.printProductPageUrl();
    }

    /**
     * Scenario: verify the details of MacbookPro
     */
    @Then("verify the title of the product is {string}")
    public void verifyTheTitleOfTheProductIs(String expectedTitle) {
        Container.productPage.verifyProductTitle(expectedTitle);
    }

    @And("verify the brand is {string}")
    public void verifyTheBrandIs(String expectedBrand) {
        Container.productPage.verifyBrand(expectedBrand);
    }

    @And("verify the product code is {string}")
    public void verifyTheProductCodeIs(String expectedProductCode) {
        Container.productPage.verifyProductCode(expectedProductCode);
    }

    @And("verify the reward points are {string}")
    public void verifyTheRewardPointsAre(String expectedRewardPoints) {
        Container.productPage.verifyRewardPoints(expectedRewardPoints);
    }

    @And("verify the price is {string}")
    public void verifyThePriceIs(String expectedPrice) {
        Container.productPage.verifyPrice(expectedPrice);
    }
}