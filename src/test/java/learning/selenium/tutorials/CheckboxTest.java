package learning.selenium.tutorials;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static learning.selenium.tutorials.SeleniumAssertion.softAssertions;

public class CheckboxTest extends SeleniumBase {
    private final By pageTitle = By.cssSelector("#content>div>h3");
    private final By checkbox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    private final By checkbox2 = By.xpath("//form[@id='checkboxes']/input[2]");

    @Test(priority = 1)
    public void openBaseUri() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        softAssertions.assertThat(driver.findElement(pageTitle).getText()).isEqualTo("Checkboxes");
    }

    @Test(priority = 2)
    public void selectCheckbox1() {
        driver.findElement(checkbox1).click();
        softAssertions.assertThat(driver.findElement(checkbox1).getAttribute("checked")).isEqualTo("true");
    }

    @Test(priority = 3)
    public void deselectCheckbox2() {
        driver.findElement(checkbox2).click();
        softAssertions.assertThat(driver.findElement(checkbox2).getAttribute("checked")).isEqualTo(null);
    }
}
