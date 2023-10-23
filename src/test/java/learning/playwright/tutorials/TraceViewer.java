package learning.playwright.tutorials;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class TraceViewer {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            // Start tracing
            browserContext.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            page.navigate("https://sairam2112002.github.io/survey-form/");
            page.getByPlaceholder("Enter yor name").click();
            page.getByPlaceholder("Enter yor name").fill("Harry Potter");
            page.getByPlaceholder("Enter yor email").click();
            page.getByPlaceholder("Enter yor email").fill("hogwarts@gmail.com");
            page.getByPlaceholder("Age").click();
            page.getByPlaceholder("Age").fill("20");
            page.getByLabel("Which option best describes your current role?").selectOption("Full Time Job");
            page.getByLabel("Definitely").check();
            page.locator("input:nth-child(18)").check();
            page.getByPlaceholder("Enter your comment here...").click();
            page.getByPlaceholder("Enter your comment here...").fill("FreeCodeCamp is a great place to learn");

            // Stop tracing and export it into a zip archive
            browserContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Utilities\\Traces\\trace.zip")));
            browserContext.close();
        }
    }
}
