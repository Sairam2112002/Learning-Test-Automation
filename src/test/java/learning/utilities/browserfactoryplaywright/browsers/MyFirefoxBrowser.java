package learning.utilities.browserfactoryplaywright.browsers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import learning.utilities.browserfactoryplaywright.Browsers;

public class MyFirefoxBrowser implements Browsers {
    @Override
    public Browser getBrowser() {
        Playwright playwright = Playwright.create();
        return playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }
}
