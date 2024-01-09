package learning.cucumberselenium.nopcommerce.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import learning.cucumberselenium.nopcommerce.pages.PageContext;

import java.util.List;

public class CommonStepDefinitions {
    private final PageContext pageContext;

    public CommonStepDefinitions(PageContext pageContext) {
        this.pageContext = pageContext;
    }
}
