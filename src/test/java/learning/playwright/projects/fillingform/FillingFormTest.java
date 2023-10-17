package learning.playwright.projects.fillingform;

import com.microsoft.playwright.*;
import learning.playwright.projects.fillingform.pages.FormPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class FillingFormTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected FormPage formPage;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test(priority = 1)
    public void openBaseUri() {
        formPage = new FormPage(page);
        formPage.openFormPage();
    }

    @Test(priority = 2)
    public void fillDetails() {
        formPage = formPage.enterDetails();
    }

    @Test(priority = 3)
    public void nameVerification() {
        formPage.verifyName("Harry Potter");
    }

    @Test(priority = 4)
    public void emailVerification() {
        formPage.verifyEmail("hogwarts@gmail.com");
    }

    @Test(priority = 5)
    public void ageVerification() {
        formPage.verifyAge("20");
    }

    @Test(priority = 6)
    public void roleVerification() {
        formPage.verifyRole();
    }

    @Test(priority = 7)
    public void recommendationVerification() {
        formPage.verifyRecommendation();
    }

    @Test(priority = 8)
    public void improvementVerification() {
        formPage.verifyImprovements();
    }

    @Test(priority = 9)
    public void suggestionsVerification() {
        formPage.verifySuggestions("FreeCodeCamp is a great place to learn");
    }

    @AfterClass
    public void tearDown() {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshots\\FilledForm.png")));
        browser.close();
        playwright.close();
    }
}
