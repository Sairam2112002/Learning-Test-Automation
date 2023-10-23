package learning.cucumberPlaywright.opencart.pages;

import com.microsoft.playwright.Page;

public class SearchResultsPage {
    private final Page page;

    public SearchResultsPage(Page page) {
        this.page = page;
    }

    private static final String MACBOOK_PRO = "img[title='MacBook Pro']";

    public void printSearchResultsPageUrl() {
        System.out.println(page.url());
    }

    public ProductPage clickOnMacbookPro() {
        page.locator(MACBOOK_PRO).click();
        return new ProductPage(page);
    }
}