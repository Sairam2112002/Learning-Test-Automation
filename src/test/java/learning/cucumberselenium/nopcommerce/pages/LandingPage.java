package learning.cucumberselenium.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static learning.cucumberselenium.nopcommerce.stepdefinitions.HooksNOPCommerceSelenium.*;

public class LandingPage extends BasePage{
    private static final String NOP_COMMERCE_URL = "https://www.nopcommerce.com/en/demo";

    public Map<String, By> landingPageLinks;

    public LandingPage(WebDriver driver) {
        super(driver);

        landingPageLinks = new HashMap<>();
        landingPageLinks.put("Landing Page Title", By.cssSelector(".page-title>h1"));
        landingPageLinks.put("Landing Page description", By.cssSelector(".main-sub-title>p"));

        commonLinks.put("Showcase", By.cssSelector(".stats-1"));
        commonLinks.put("Case studies", By.cssSelector(".stats-2"));
        commonLinks.put("All features", By.cssSelector(".stats-3"));
        commonLinks.put("Showcase link", By.cssSelector(".stats-1>a"));
        commonLinks.put("Case studies link", By.cssSelector(".stats-2>a"));
        commonLinks.put("All features link", By.cssSelector(".stats-3>a"));
        commonLinks.put("Product", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/span"));
        commonLinks.put("Downloads", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[2]/span"));
        commonLinks.put("Support & services", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[3]/span"));
        commonLinks.put("Partners", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[4]/a/span"));
    }

    public void navigateToNopCommerce() {
        openUrl(driver, NOP_COMMERCE_URL);
    }

    public void verifyNopCommerceLandingPage() {
        softAssertions.assertThat(getText(driver.findElement(landingPageLinks.get("Landing Page Title")))).isEqualTo("nopCommerce Store Demo");
    }

    public void verifyLandingPageTitleDescription(String description) {
        softAssertions.assertThat(getText(driver.findElement(landingPageLinks.get("Landing Page description")))).isEqualTo(description);
    }
}
