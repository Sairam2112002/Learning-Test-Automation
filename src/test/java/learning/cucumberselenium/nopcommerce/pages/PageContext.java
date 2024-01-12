package learning.cucumberselenium.nopcommerce.pages;

import learning.cucumberselenium.general.pages.WebPage;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

public class PageContext {
    private static WebPage _basePage;
    private static WebPage _landingPage;

    public static void initContext(WebDriver driver) {
        _basePage = () -> new BasePage(driver);
        _landingPage = () -> new LandingPage(driver);
    }

    @Getter @Setter
    private BasePage currentPage;
    @Getter
    private final BasePage basePage = (BasePage) _basePage.get();
    @Getter
    private final LandingPage landingPage = (LandingPage) _landingPage.get();
}
