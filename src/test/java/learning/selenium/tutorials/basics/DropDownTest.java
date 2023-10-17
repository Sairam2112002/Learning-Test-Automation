package learning.selenium.tutorials.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownTest extends Utilities {
    private Select select;

    @BeforeClass
    private void openBaseUri() {
        driver.get("https://artoftesting.com/samplesiteforselenium");
        driver.manage().window().maximize();
        WebElement dropDownMenu = driver.findElement(By.cssSelector("#testingDropdown"));
        select = new Select(dropDownMenu);
    }

    @Test(priority = 1)
    public void dropDown1() {
        select.selectByVisibleText("Performance Testing");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Performance Testing");
    }

    @Test(priority = 2)
    public void dropDown2() {
        select.selectByIndex(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Manual Testing");
    }

    @Test(priority = 3)
    public void dropDown3() {
        select.selectByValue("Database");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Database Testing");
    }
}
