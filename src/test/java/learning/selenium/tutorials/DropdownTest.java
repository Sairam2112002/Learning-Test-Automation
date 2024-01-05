package learning.selenium.tutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownTest extends SeleniumBase{
    private final By pageTitle = By.cssSelector("#content>div>h3");
    private final By dropdown =  By.cssSelector("#content #dropdown");
    private final By dropdownOption1 = By.cssSelector("option[value='1']");
    private final By dropdownOption2 = By.cssSelector("option[value='2']");

    @Test(priority = 1)
    public void openBaseUri() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        softAssert.assertEquals(driver.findElement(pageTitle).getText(), "Dropdown List");
    }

    @Test(priority = 2)
    public void selectOption1FromDropdown() {
        select = new Select(driver.findElement(dropdown));
        select.selectByValue("1");
        softAssert.assertFalse(driver.findElement(dropdownOption1).getAttribute("selected").isEmpty());
    }

    @Test(priority = 3)
    public void selectOption2FromDropdown() {
        select = new Select(driver.findElement(dropdown));
        select.selectByValue("2");
        softAssert.assertFalse(driver.findElement(dropdownOption2).getAttribute("selected").isEmpty());
    }
}
