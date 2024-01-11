package learning.cucumberselenium.nopcommerce.pages;

import learning.cucumberselenium.general.pages.WebPage;
import learning.cucumberselenium.general.utilities.WebActionImplementations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public void verifyElementsVisibility(List<String> elements) {
        for(String element: elements) {
            WebElement webElement = driver.findElement(commonLinks.get(element));
            waitForElementToBeVisible(driver, webElement, 5);
            scrollToElement(driver, webElement);
            softAssertions.assertThat(webElement.isDisplayed()).isTrue();
        }
    }

    public void clickLinkOnCurrentPageToOpenInNewTab(String linkText) {
        openLinkInNewTab(driver, driver.findElement(commonLinks.get(linkText + " link")));
        switchToNewlyOpenedTab(driver);
    }

    public void validateUrlInNewTab(String link) {
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(link);
    }

    public void hoverOnSection(String sectionName) {
        hoverOnElement(driver, driver.findElement(commonLinks.get(sectionName)));
    }

    public void verifyOptionsAreDisplayedForTheSection(String optionsAsString) {
        String[] options = optionsAsString.split(",");
        for(String option: options) {
            WebElement element = driver.findElement(commonLinks.get(option));
            waitForElementToBeVisible(driver, element, 5);
            softAssertions.assertThat(element.isDisplayed()).isTrue();
        }
    }
}
