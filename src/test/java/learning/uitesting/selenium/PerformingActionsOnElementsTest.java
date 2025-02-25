package learning.uitesting.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class PerformingActionsOnElementsTest extends SeleniumBaseTest {
    @Test(priority = 1)
    public void enteringText() {
        driver.get(GOOGLE_SEARCH_URL);

        WebElement googleSearchBar = driver.findElement(By.xpath("(//textarea)[1]"));
        googleSearchBar.sendKeys("Google");
    }

    @Test(priority = 2)
    public void clearingText() {
        driver.get(GOOGLE_SEARCH_URL);

        WebElement googleSearchBar = driver.findElement(By.xpath("(//textarea)[1]"));
        googleSearchBar.sendKeys("Google");

        googleSearchBar.clear();
    }

    @Test(priority = 3)
    public void clickingButton() {
        driver.get(OPEN_CART_URL);
        WebElement contactButton = driver.findElement(By.cssSelector("i.fa-phone"));

        contactButton.click();
        logger.info(driver.getTitle());
    }

    @Test(priority = 4)
    public void checkboxes() {
        driver.get(HEROKU_CHECKBOXES);
        List<WebElement> checkboxes = driver.findElements(By.xpath("//form[@id='checkboxes']/input"));

        checkboxes.getFirst().click();
        checkboxes.get(1).click();
    }

    @Test(priority = 5)
    public void radioButtons() {
        driver.get(LAMBDA_TEST_RADIO_BUTTONS);
        WebElement maleRadioButton = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement getValueButton = driver.findElement(By.xpath("//button[@id='buttoncheck']"));

        maleRadioButton.click();
        getValueButton.click();
    }

    @Test(priority = 6)
    public void selectDropdown() {
        driver.get(LAMBDA_TEST_SELECT_DROPDOWN);
        WebElement dropdownSelectElement = driver.findElement(By.xpath("//select[@id='select-demo']"));
        Select selectDropdown = new Select(dropdownSelectElement);

        selectDropdown.selectByVisibleText("Sunday");
        selectDropdown.selectByIndex(2);
        selectDropdown.selectByValue("Tuesday"); // value of "value" attribute of Option element
    }
}
