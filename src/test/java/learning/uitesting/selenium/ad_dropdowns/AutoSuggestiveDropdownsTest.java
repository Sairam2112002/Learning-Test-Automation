package learning.uitesting.selenium.ad_dropdowns;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class AutoSuggestiveDropdownsTest extends SeleniumBaseTest {
    public AutoSuggestiveDropdownsTest() {
        xpathLocators.put("AUTO_SUGGEST_DROPDOWN", "//input[@id='autosuggest']");
        xpathLocators.put("AUTO_SUGGEST_DROPDOWN_SUGGESTIONS", "//li[@class='ui-menu-item']/a");
    }

    @Test(priority = 1)
    public void setup() {
        driver.get(RAHUL_SHETTY_ACADEMY_DROPDOWN_PRACTICE);
    }

    @Test(priority = 2)
    public void autoSuggestDropdown() {
        driver.findElement(By.xpath(xpathLocators.get("AUTO_SUGGEST_DROPDOWN"))).sendKeys("Ind");

        waitForElementToBeClickable(xpathLocators.get("AUTO_SUGGEST_DROPDOWN_SUGGESTIONS"));
        List<WebElement> suggestions = driver.findElements(By.xpath(xpathLocators.get("AUTO_SUGGEST_DROPDOWN_SUGGESTIONS")));
        suggestions.forEach(element -> System.out.println(element.getText()));
        for(WebElement element: suggestions) {
            if(element.getText().equalsIgnoreCase("India")) {
                element.click();
                break;
            }
        }
    }
}
