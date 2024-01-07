package learning.selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CheckboxTest extends SeleniumBase {
    private final By pageTitle = By.cssSelector("#content>div>h3");
    private final By checkbox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    private final By checkbox2 = By.xpath("//form[@id='checkboxes']/input[2]");

    @Test()
    public void selectCheckbox() {
        openBaseUri("https://the-internet.herokuapp.com/checkboxes");
        softAssertions.assertThat(driver.findElement(pageTitle).getText()).isEqualTo("Checkboxes");

        driver.findElement(checkbox1).click();
        softAssertions.assertThat(driver.findElement(checkbox1).getAttribute("checked")).isEqualTo("true");

        driver.findElement(checkbox2).click();
        softAssertions.assertThat(driver.findElement(checkbox2).getAttribute("checked")).isEqualTo(null);

        softAssertions.assertAll();
    }
}
