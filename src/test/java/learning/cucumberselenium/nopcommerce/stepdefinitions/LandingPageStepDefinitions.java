package learning.cucumberselenium.nopcommerce.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import learning.cucumberselenium.nopcommerce.pages.PageContext;

public class LandingPageStepDefinitions {
    private final PageContext pageContext;

    public LandingPageStepDefinitions(PageContext pageContext) {
        this.pageContext = pageContext;
        this.pageContext.setCurrentPage(pageContext.getLandingPage());
    }

    @Given("I navigate to NOP Commerce Landing Page")
    public void iNavigateToNopCommerceLandingPage() {
        pageContext.setCurrentPage(pageContext.getLandingPage());
        pageContext.getLandingPage().navigateToNopCommerce();
    }

    @Given("I am on NOP Commerce Landing Page")
    public void iAMOnNopCommerceLandingPage() {
        pageContext.getLandingPage().verifyNopCommerceLandingPage();
    }

    @Then("below description must be displayed for landing page")
    public void belowDescriptionMustBeDisplayedForLandingPage(DataTable dataTable) {
        String description = dataTable.row(0).get(0);
        pageContext.getLandingPage().verifyLandingPageTitleDescription(description);
    }
}
