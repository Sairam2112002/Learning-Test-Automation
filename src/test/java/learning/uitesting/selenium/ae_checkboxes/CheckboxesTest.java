package learning.uitesting.selenium.ae_checkboxes;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckboxesTest extends SeleniumBaseTest {
    public CheckboxesTest() {
        xpathLocators.put("SINGLE_CHECKBOX", "//input[@id='isAgeSelected']");
        xpathLocators.put("ALL_CHECKBOXES", "//input[@type='checkbox']");
    }

    @Test(priority = 1)
    public void setUp() {
        driver.get(LAMBDATEST_CHECKBOXES_URL);
    }

    @Test(priority = 2)
    public void selectAndDeselectCheckboxes() {
        WebElement singleCheckbox = driver.findElement(By.xpath(xpathLocators.get("SINGLE_CHECKBOX")));

        logger.info(singleCheckbox.isSelected());
        singleCheckbox.click();
        logger.info(singleCheckbox.isSelected());
    }

    @Test(priority = 3)
    public void countNumberOfCheckboxes() {
        logger.info("Number of checkboxes = " + driver.findElements(By.xpath(xpathLocators.get("ALL_CHECKBOXES"))).size());
    }
}
