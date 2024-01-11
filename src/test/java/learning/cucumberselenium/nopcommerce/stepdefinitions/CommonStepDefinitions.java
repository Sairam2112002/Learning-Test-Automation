package learning.cucumberselenium.nopcommerce.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import learning.cucumberselenium.nopcommerce.pages.PageContext;

import java.util.List;

public class CommonStepDefinitions {
    private final PageContext pageContext;

    public CommonStepDefinitions(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    @Then("below elements must be visible")
    public void belowElementsMustBeVisible(DataTable dataTable) {
        List<String> elements = dataTable.asList();
        pageContext.getCurrentPage().verifyElementsVisibility(elements);
    }

    @And("I click {string} link in new tab")
    public void iClickLinkInNewTab(String linkText) {
        pageContext.getCurrentPage().clickLinkOnCurrentPageToOpenInNewTab(linkText);
    }

    @Then("the corresponding {string} url should be displayed")
    public void theCorrespondingUrlShouldBeDisplayed(String link) {
        pageContext.getCurrentPage().validateUrlInNewTab(link);
    }

    @When("I hover on {string} element in landing page")
    public void iHoverOnSectionInLandingPage(String sectionName) {
        pageContext.getCurrentPage().hoverOnSection(sectionName);
    }

    @Then("the options {string} should be displayed")
    public void theOptionsShouldBeDisplayedForTheSection(String optionsAsString) {
        pageContext.getCurrentPage().verifyOptionsAreDisplayedForTheSection(optionsAsString);
    }
}
