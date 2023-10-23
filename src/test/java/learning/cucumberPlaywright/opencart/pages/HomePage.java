package learning.cucumberPlaywright.opencart.pages;

import com.microsoft.playwright.Page;

import static learning.cucumberPlaywright.OpencartConstants.OPENCART_HOMEPAGE;

public class HomePage {
    private final Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    private static final String SEARCH_BAR = "input[name='search']";
    private static final String SEARCH_BUTTON = "#search button";

    public void openBaseUri() {
        page.navigate(OPENCART_HOMEPAGE);
    }

    public SearchResultsPage search(String textToSearch) {
        page.locator(SEARCH_BAR).fill(textToSearch);
        page.locator(SEARCH_BUTTON).click();
        return new SearchResultsPage(page);
    }
}
