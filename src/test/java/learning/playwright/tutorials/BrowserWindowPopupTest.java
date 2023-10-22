package learning.playwright.tutorials;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

/**
 * Handling Window Popup
 * Opening New Tab
 */
public class BrowserWindowPopupTest {
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
     * Handling Window Popup
     */
    @Test(priority = 1)
    public void windowPopup() {
        page.navigate("https://www.orangehrm.com/en/book-a-free-demo/");
        System.out.println(page.title());

        Page poppedUpPage = page.waitForPopup(() -> {
            page.locator("css=img[alt='facebook logo']").click();
        });

        poppedUpPage.waitForLoadState(); // To wait until the popped up page loads completely
        System.out.println(poppedUpPage.title());
        System.out.println("====================================================================");
    }

    /**
     * Opening a New Tab
     */
    @Test(priority = 2)
    public void openNewTab() {
        page.navigate("https://opensource-demo.orangehrmlive.com");
        System.out.println(page.title());

        Page newTabPage = page.waitForPopup(() -> {
                page.click("a[target='_blank']");   // Opens a New Tab
        });

        newTabPage.waitForLoadState(); // To wait until the New Tab completely loads
        newTabPage.navigate("https://www.google.com");
        System.out.println(newTabPage.title());
    }
}
