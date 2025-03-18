package learning.uitesting.selenium.ag_element_state;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckingIfElementIsEnabledTest extends SeleniumBaseTest {
    public CheckingIfElementIsEnabledTest() {
        xpathLocators.put("DEPARTURE_DATE_BLOCK", "//div[@data-testid='departure-date-dropdown-label-test-id']");
        xpathLocators.put("RETURN_DATE_BLOCK", "//div[@data-testid='return-date-dropdown-label-test-id']");
        xpathLocators.put("ROUND_TRIP_RADIO_BUTTON", "//div[text()='round trip']");
    }

    @Test(priority = 1)
    public void setUp() {
        driver.get(SPICEJET_URL);
    }

    @Test(priority = 2)
    public void usingIsEnableMethod() {
        logger.info(driver.findElement(By.xpath(xpathLocators.get("DEPARTURE_DATE_BLOCK"))).isEnabled());
        logger.info(driver.findElement(By.xpath(xpathLocators.get("RETURN_DATE_BLOCK"))).isEnabled());
    }

    @Test(priority = 3)
    public void checkingTheChangesInElementAttributes() {
        logger.info(isDateBlockEnabled(xpathLocators.get("DEPARTURE_DATE_BLOCK")));
        logger.info(isDateBlockEnabled(xpathLocators.get("RETURN_DATE_BLOCK")));

        driver.findElement(By.xpath(xpathLocators.get("ROUND_TRIP_RADIO_BUTTON"))).click();
        logger.info(isDateBlockEnabled(xpathLocators.get("RETURN_DATE_BLOCK")));
    }

    private boolean isDateBlockEnabled(String xpathLocator) {
        WebElement departureDateBlock = driver.findElement(By.xpath(xpathLocator));
        String backgroundColor = departureDateBlock.getCssValue("background-color");

        return !backgroundColor.equals("rgba(238, 238, 238, 1)");
    }
}
