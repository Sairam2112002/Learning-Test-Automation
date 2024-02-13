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
        commonLinks.put("Partners link", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[4]/a/span"));
        commonLinks.put("Store demo", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[1]/a/span"));
        commonLinks.put("Showcase Option", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[2]/a/span"));
        commonLinks.put("Features", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[3]/a/span"));
        commonLinks.put("Why for developers", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[4]/a/span"));
        commonLinks.put("Why for store owners", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[5]/a/span"));
        commonLinks.put("Industries", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[6]/span"));
        commonLinks.put("Fashion", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[6]/ul/li[1]/a/span"));
        commonLinks.put("Health & Beauty", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[6]/ul/li[2]/a/span"));
        commonLinks.put("Food & Beverage", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[6]/ul/li[3]/a/span"));
        commonLinks.put("Automotive", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[6]/ul/li[4]/a/span"));
        commonLinks.put("Industrial & Scientific", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[6]/ul/li[5]/a/span"));
        commonLinks.put("Furniture", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[6]/ul/li[6]/a/span"));
        commonLinks.put("B2B eCommerce", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[6]/ul/li[7]/a/span"));
        commonLinks.put("International", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[1]/ul/li[6]/ul/li[8]/a/span"));
        commonLinks.put("Download nopCommerce", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[2]/ul/li[1]/a/span"));
        commonLinks.put("Marketplace", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[2]/ul/li[2]/a/span"));
        commonLinks.put("Translations", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[2]/ul/li[3]/a/span"));
        commonLinks.put("Copyright removal key", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[2]/ul/li[4]/a/span"));
        commonLinks.put("Mobile application", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[2]/ul/li[5]/a/span"));
        commonLinks.put("Web API", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[2]/ul/li[6]/a/span"));
        commonLinks.put("Training", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[3]/ul/li[1]/a/span"));
        commonLinks.put("Documentation", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[3]/ul/li[2]/a/span"));
        commonLinks.put("Community forums", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[3]/ul/li[3]/a/span"));
        commonLinks.put("Premium support services", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[3]/ul/li[4]/a/span"));
        commonLinks.put("Request a quote", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[3]/ul/li[5]/a/span"));
        commonLinks.put("Contact us", By.xpath("//div[@class='navigation-body']/div/ul[1]/li[3]/ul/li[6]/a/span"));
        commonLinks.put("Admin area link", By.cssSelector(".demo-buttons>a:nth-child(1)"));
        commonLinks.put("Frontend link", By.cssSelector(".demo-buttons>a:nth-child(2)"));
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
