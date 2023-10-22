package learning.playwright.tutorials;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

import java.util.List;

public class SingleAndMultipleElementsTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeMethod
    public void setupBrowserContext() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @AfterMethod
    public void teardownBrowserContext() {
        browserContext.close();
    }

    @AfterClass
    public void teardown() {
        browser.close();
        playwright.close();
    }

    /**
     * Locating a Single Element
     */
    @Test(priority = 1)
    public void singleElement() {
        page.navigate("https://naveenautomationlabs.com/opencart/");
        Locator searchBar = page.locator("css=input[name='search']");
        searchBar.fill("Apple");
    }

    /**
     * Locating Multiple Elements
     * Locating first, last and nth items
     */
    @Test(priority = 2)
    public void multipleElements() {
        page.navigate("https://www.orangehrm.com/en/book-a-free-demo/");
        Locator countries = page.locator("css=#Form_getForm_Country_Holder>div>select>option");
        System.out.println(countries.count());
        System.out.println(countries.first().textContent());
        System.out.println(countries.last().textContent());
        System.out.println(countries.nth(100).textContent());
    }

    /**
     * Getting the textContent of all Elements of the given selector
     */
    @Test(priority = 3)
    public void textContentOfMultipleElements() {
        page.navigate("https://www.orangehrm.com/en/book-a-free-demo/");
        Locator countries = page.locator("css=#Form_getForm_Country_Holder>div>select>option");
        List<String> countriesTextContent = countries.allTextContents();
        countriesTextContent.forEach(System.out::println);
    }


}
