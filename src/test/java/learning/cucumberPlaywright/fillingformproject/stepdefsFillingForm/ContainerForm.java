package learning.cucumberPlaywright.fillingformproject.stepdefsFillingForm;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import learning.cucumberPlaywright.fillingformproject.pagesFillingForm.FillingFormPage;

public class ContainerForm {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static Page page;
    protected static FillingFormPage formPage;

    @BeforeAll
    public static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        formPage = new FillingFormPage(page);
    }

    @AfterAll
    public static void tearDown() {
        browser.close();
        playwright.close();
    }
}
