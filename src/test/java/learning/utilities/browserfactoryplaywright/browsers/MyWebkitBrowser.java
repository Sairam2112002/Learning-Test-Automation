package learning.utilities.browserfactoryplaywright.browsers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import learning.utilities.browserfactoryplaywright.Browsers;

public class MyWebkitBrowser implements Browsers {
    @Override
    public Browser getBrowser() {
        Playwright playwright = Playwright.create();
        return playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }
}
