package learning.playwright.tutorials;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class RecordingVideo {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("Utilities\\VideoRecordings\\")));
        Page page = browserContext.newPage();

        page.navigate("https://www.orangehrm.com/");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book a Free Demo")).click();
        page.getByPlaceholder("Your Full Name*").click();
        page.getByPlaceholder("Your Full Name*").fill("dobby");
        page.getByPlaceholder("Business Email*").click();
        page.getByPlaceholder("Business Email*").fill("dobby@gmail.com");
        page.getByPlaceholder("Company Name").click();
        page.getByPlaceholder("Company Name").fill("xyz");
        page.getByLabel("Country").selectOption("Canada");
        page.getByPlaceholder("Phone Number*").click();
        page.getByPlaceholder("Phone Number*").fill("0000000000");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Get a Free Demo")).click();

        browserContext.close();
        browser.close();
        playwright.close();
    }
}
