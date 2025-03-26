package learning.uitesting.selenium.complexscenarios.workingonlinks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.*;

/*
 * Steps:
 * Navigate to Lambdatest Selenium Playground
 * Count all the links available in the page
 * Count all the links available in the page footer
 * Count all the links available in "Browser Automation" section of the footer
 * Open all the links in "Browser Automation" section and print the respective titles
 */
public class LambdatestLinksTest extends LambdatestLinksBaseTest {
    private static final Map<String, String> xpathLocators = new HashMap<>();

    public LambdatestLinksTest() {
        xpathLocators.put("footer", "//footer[@id='footer']");
        xpathLocators.put("browser automation footer", "//div[contains(text(), 'Browser Automation')]/following-sibling::ul[1]");
        xpathLocators.put("browser automation footer links", "//div[contains(text(), 'Browser Automation')]/following-sibling::ul[1]/li/a");
    }

    @Test(priority = 1)
    public void countNumberOfLinks() {
        int numberOfLinks = driver.findElements(By.tagName("a")).size();
        logger.info("Number of links in the page = " + numberOfLinks);
    }

    @Test(priority = 2)
    public void countNumberOfLinksInTheFooter() {
        WebElement footer = driver.findElement(By.xpath(xpathLocators.get("footer")));
        int numberOfLinks = footer.findElements(By.tagName("a")).size();
        logger.info("Number of links in the page footer = " + numberOfLinks);
    }

    @Test(priority = 3)
    public void countNumberOfLinksInBrowserAutomationSectionInFooter() {
        WebElement browserAutomationFooter = driver.findElement(By.xpath(xpathLocators.get("browser automation footer")));
        int numberOfLinks = browserAutomationFooter.findElements(By.tagName("a")).size();
        logger.info("Number of links in the browser automation section in the page footer = " + numberOfLinks);
    }

    @Test(priority = 4)
    public void openLinksInBrowserAutomationSectionInFooter() {
        List<WebElement> links = driver.findElements(By.xpath(xpathLocators.get("browser automation footer links")));

        for(WebElement link: links) {
            String keysChord = Keys.chord(Keys.LEFT_CONTROL, Keys.ENTER);
            link.sendKeys(keysChord);
        }

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        iterator.next();

        logger.info("Links opened:");
        while(iterator.hasNext()) {
            String windowHandle = iterator.next();
            driver.switchTo().window(windowHandle);
            logger.info(driver.getTitle());
        }
    }
}
