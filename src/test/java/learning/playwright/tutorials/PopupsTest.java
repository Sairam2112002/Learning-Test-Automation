package learning.playwright.tutorials;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

/**
 * JS Alert
 * JS Prompt
 * JS Confirm
 */
public class PopupsTest {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

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
     * JS Alert
     * After an alert is appeared, Playwright automatically handles it by clicking OK
     */
    @Test(priority = 1)
    public void alert() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.locator("text='Click for JS Alert'").click();
        System.out.println(page.locator("css=#result").textContent());
    }

    /**
     * JS Confirm
     * After a confirmation is appeared, Playwright automatically handles it by clicking cancel
     */
    @Test(priority = 2)
    public void confirmation() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.locator("text='Click for JS Confirm'").click();
        System.out.println(page.locator("css=#result").textContent());
    }

    /**
     * JS Prompt
     * In this case, "onDialog" Listener is used to enter the message in the prompt
     * This Listener is defined after navigating to an url in a page, before performing any actions in that page
     * This Listener is applicable for every "alert, prompt and confirm" in that page
     */
    @Test(priority = 3)
    public void prompt() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.onDialog(dialog -> {
            System.out.println(dialog.message());
            dialog.accept("This is a sample message entered");
        });
        page.locator("text='Click for JS Prompt'").click();
        System.out.println(page.locator("css=#result").textContent());
    }

    /**
     * JS Alert
     * Handling JS Alert and using "onDialog" Listener
     */
    @Test(priority = 4)
    public void alertUsingListener() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.onDialog(dialog -> {
            System.out.println(dialog.message());
            dialog.accept();
            //  dialog.dismiss(); -> used to dismiss the alert or confirmation
        });
        page.locator("text='Click for JS Alert'").click();
        System.out.println(page.locator("css=#result").textContent());
    }

    /**
     * JS Confirm
     * Handling JS Confirm and using "onDialog" Listener
     */
    @Test(priority = 5)
    public void confirmationUsingListener() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.onDialog(dialog -> {
            System.out.println(dialog.message());
            dialog.accept();
            //  dialog.dismiss(); -> used to dismiss the alert or confirmation
        });
        page.locator("text='Click for JS Confirm'").click();
        System.out.println(page.locator("css=#result").textContent());
    }
}
