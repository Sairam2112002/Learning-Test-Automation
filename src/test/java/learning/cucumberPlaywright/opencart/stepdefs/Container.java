package learning.cucumberPlaywright.opencart.stepdefs;

import com.microsoft.playwright.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import learning.cucumberPlaywright.opencart.pages.HomePage;
import learning.cucumberPlaywright.opencart.pages.ProductPage;
import learning.cucumberPlaywright.opencart.pages.SearchResultsPage;

import java.io.IOException;

public class Container {
    static Playwright playwright;
    static Browser browser;
    static Page page;

    static HomePage homePage;
    static ProductPage productPage;
    static SearchResultsPage searchResultsPage;

    @BeforeAll
    public static void setup() throws IOException {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        homePage = new HomePage(page);
    }

    @AfterAll
    public static void teardown() {
        browser.close();
        playwright.close();
    }
}
