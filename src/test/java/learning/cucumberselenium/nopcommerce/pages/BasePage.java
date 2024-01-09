package learning.cucumberselenium.nopcommerce.pages;

import learning.cucumberselenium.general.pages.WebPage;
import learning.cucumberselenium.general.utilities.WebActionImplementations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static learning.cucumberselenium.nopcommerce.stepdefinitions.HooksNOPCommerceSelenium.*;

public class BasePage extends WebActionImplementations implements WebPage {
    public final WebDriver driver;

    public Map<String, By> commonLinks;

    @Override
    public WebPage get() {
        return this;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        commonLinks = new HashMap<>();
    }
}
