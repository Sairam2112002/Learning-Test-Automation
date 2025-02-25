package learning.uitesting.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class PerformingActionsOnElementsTest extends SeleniumBaseTest {
    @Test
    public void testPerformingActions() throws InterruptedException {
        // Entering text
        driver.get(GOOGLE_SEARCH_URL);

        WebElement googleSearchBar = driver.findElement(By.xpath("(//textarea)[1]"));
        googleSearchBar.sendKeys("Google");

        // Clearing text
        googleSearchBar.clear();

        // Clicking a button
        driver.get(OPEN_CART_URL);
        WebElement contactButton = driver.findElement(By.cssSelector("i.fa-phone"));
        contactButton.click();
        logger.info(driver.getTitle());

        // Checkboxes
        driver.get(HEROKU_CHECKBOXES);
        List<WebElement> checkboxes = driver.findElements(By.xpath("//form[@id='checkboxes']/input"));

        checkboxes.getFirst().click();
        checkboxes.get(1).click();

        // Radio Buttons
        driver.get(LAMBDA_TEST_RADIO_BUTTONS);
        WebElement maleRadioButton = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement getValueButton = driver.findElement(By.xpath("//button[@id='buttoncheck']"));

        maleRadioButton.click();
        getValueButton.click();

        // Select Dropdown
        driver.get(LAMBDA_TEST_SELECT_DROPDOWN);
        WebElement dropdownSelectElement = driver.findElement(By.xpath("//select[@id='select-demo']"));
        Select selectDropdown = new Select(dropdownSelectElement);

        selectDropdown.selectByVisibleText("Sunday");
        selectDropdown.selectByIndex(2);
        selectDropdown.selectByValue("Tuesday"); // value of "value" attribute of Option element
    }
}
