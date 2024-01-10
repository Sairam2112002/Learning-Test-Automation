package learning.cucumberselenium.nopcommerce.pages;

import learning.cucumberselenium.general.pages.WebPage;
import learning.cucumberselenium.general.utilities.WebActionImplementations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static learning.cucumberselenium.nopcommerce.stepdefinitions.HooksNOPCommerceSelenium.*;

public class BasePage extends WebActionImplementations implements WebPage {
    public final WebDriver driver;

    public static List<String> windowHandles;

    public Map<String, By> commonLinks;

    @Override
    public WebPage get() {
        return this;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        commonLinks = new HashMap<>();
    }

    public void verifyElementsVisibility(List<String> elements) {
        for(String element: elements) {
            scrollToElement(driver, driver.findElement(commonLinks.get(element)));
            softAssertions.assertThat(driver.findElement(commonLinks.get(element)).isDisplayed()).isTrue();
        }
    }

    public void clickLinkOnCurrentPageToOpenInNewTab(String linkText) {
        openLinkInNewTab(driver, driver.findElement(commonLinks.get(linkText + " link")));

        windowHandles = new ArrayList<>(driver.getWindowHandles());
        switchToNewlyOpenedTab(driver, windowHandles);
    }

    public void validateUrlInNewTab(String link) {
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(link);
        System.out.println("Added a sout statement");
    }
}
