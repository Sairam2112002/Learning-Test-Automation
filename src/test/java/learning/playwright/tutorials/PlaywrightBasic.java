package learning.playwright.tutorials;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

// By default, setHeadless will be true, we can set that explicitly to false

public class PlaywrightBasic {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.youtube.com/");
            System.out.println(page.title());
            Locator searchBar = page.locator("css=input[name='search_query']");
            searchBar.fill("Breaking Bad");
            System.out.println(searchBar.inputValue());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshots\\example.png")));
        }
    }
}
