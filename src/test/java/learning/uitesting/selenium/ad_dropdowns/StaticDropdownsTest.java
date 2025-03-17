package learning.uitesting.selenium.ad_dropdowns;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class StaticDropdownsTest extends SeleniumBaseTest {
    public StaticDropdownsTest() {
        xpathLocators.put("CURRENCY_DROPDOWN", "//select[@id='ctl00_mainContent_DropDownListCurrency']");
        xpathLocators.put("PASSENGERS_DROPDOWN", "//div[@id='divpaxinfo']");
        xpathLocators.put("PASSENGERS_ADULT_INCREASE", "//span[@id='hrefIncAdt']");
        xpathLocators.put("PASSENGERS_ADULT_DECREASE", "//span[@id='hrefDecAdt']");
        xpathLocators.put("PASSENGERS_DONE_BUTTON", "//input[@id='btnclosepaxoption']");
    }

    @Test(priority = 1)
    public void openUrl() {
        driver.get(RAHUL_SHETTY_ACADEMY_DROPDOWN_PRACTICE);
    }

    @Test(priority = 2)
    public void SelectDropdown() {
        Select dropdown = new Select(driver.findElement(By.xpath(xpathLocators.get("CURRENCY_DROPDOWN"))));

        dropdown.selectByIndex(1);
        logger.info(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("AED");
        logger.info(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("USD");
        logger.info(dropdown.getFirstSelectedOption().getText());
    }

    @Test(priority = 3)
    public void dropdownLooping() {
        WebElement passengersDropdown = driver.findElement(By.xpath(xpathLocators.get("PASSENGERS_DROPDOWN")));
        passengersDropdown.click();
        logger.info(passengersDropdown.getText());

        WebElement adultIncreaseButton = driver.findElement(By.xpath(xpathLocators.get("PASSENGERS_ADULT_INCREASE")));
        WebElement adultDecreaseButton = driver.findElement(By.xpath(xpathLocators.get("PASSENGERS_ADULT_DECREASE")));

        waitForElementToBeClickable(xpathLocators.get("PASSENGERS_ADULT_INCREASE"));
        for(int i = 1; i <= 8; i++) {
            adultIncreaseButton.click();
        }
        adultDecreaseButton.click();

        WebElement passengersDoneButton = driver.findElement(By.xpath(xpathLocators.get("PASSENGERS_DONE_BUTTON")));
        passengersDoneButton.click();
        logger.info(passengersDropdown.getText());
    }
}
