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
    }

    public void navigateToNopCommerce() {
        openUrl(driver, NOP_COMMERCE_URL);
    }

    public void verifyNopCommerceLandingPage() {
        softAssertions.assertThat(getText(driver.findElement(landingPageLinks.get("Landing Page Title")))).isEqualTo("nopCommerce Store Demo");
    }

    public void verifyDescription(String description) {
        softAssertions.assertThat(getText(driver.findElement(landingPageLinks.get("Landing Page description")))).isEqualTo(description);
    }
}
