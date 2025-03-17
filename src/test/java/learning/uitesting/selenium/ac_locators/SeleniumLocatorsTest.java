package learning.uitesting.selenium.ac_locators;

import learning.uitesting.selenium.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
 * Locators are the way to identify an HTML element or elements on a web page
 * There are different ways that WebDriver use to locate web elements:
 *    id attribute
 *    class attribute
 *    name attribute
 *    tag name
 *    link text (exact text the element displays), it only works for anchor elements
 *    partial link text (locates elements that contain the given link text), it only works for anchor elements
 *    xpath
 *    css selector
 */
public class SeleniumLocatorsTest extends SeleniumBaseTest {
    private static WebElement element;

    @Test(priority = 1)
    public void openUrl() {
        driver.get(RAHUL_SHETTY_ACADEMY_LOCATORS_PRACTICE);
    }

    @Test(priority = 2)
    public void locateUsingIdAttribute() {
        element = driver.findElement(By.id("inputUsername"));
        printElementInfo();
    }

    @Test(priority = 3)
    public void locateUsingClassAttribute() {
        element = driver.findElement(By.className("form"));
        printElementInfo();
    }

    @Test(priority = 4)
    public void locateUsingNameAttribute() {
        element = driver.findElement(By.name("inputPassword"));
        printElementInfo();
    }

    @Test(priority = 5)
    public void locateUsingTagName() {
        element = driver.findElement(By.tagName("form"));
        printElementInfo();
    }

    @Test(priority = 6)
    public void locateUsingLinkText() {
        element = driver.findElement(By.linkText("Forgot your password?"));
        printElementInfo();
    }

    @Test(priority = 7)
    public void locateUsingPartialLinkText() {
        element = driver.findElement(By.partialLinkText("Forgot your"));
        printElementInfo();
    }

    @Test(priority = 8)
    public void locateUsingXPath() {
        element = driver.findElement(By.xpath("//input[@id='inputUsername']"));
        printElementInfo();
    }

    @Test(priority = 9)
    public void locateUsingCSSSelector() {
        element = driver.findElement(By.cssSelector("input#inputUsername"));
        printElementInfo();
    }

    private void printElementInfo() {
        logger.info(element.getTagName());
        logger.info(element.getLocation());
    }
}
