package learning.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownTest extends SeleniumBase {
    private final By pageTitle = By.cssSelector("#content>div>h3");
    private final By dropdown =  By.cssSelector("#content #dropdown");
    private final By dropdownOption1 = By.cssSelector("option[value='1']");
    private final By dropdownOption2 = By.cssSelector("option[value='2']");

    @Test()
    public void selectFromDropdown() {
        openBaseUri("https://the-internet.herokuapp.com/dropdown");
        softAssertions.assertThat(driver.findElement(pageTitle).getText()).isEqualTo("Dropdown List");

        select = new Select(driver.findElement(dropdown));
        select.selectByValue("1");
        softAssertions.assertThat(driver.findElement(dropdownOption1).getAttribute("selected").isEmpty()).isFalse();

        select = new Select(driver.findElement(dropdown));
        select.selectByValue("2");
        softAssertions.assertThat(driver.findElement(dropdownOption2).getAttribute("selected").isEmpty()).isFalse();

        softAssertions.assertAll();
    }
}
