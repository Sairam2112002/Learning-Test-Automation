package learning.uitesting.selenium.aj_actions_class;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*
 * Actions class in Selenium is used to perform Mouse and Keyboard actions
 *
 * Actions class implements builder pattern i.e. we can build a composite action that contains chain of individual
 * actions and are executed in sequence.
 *
 * Some examples are given below
 */
public class ActionsClassTest extends SeleniumBaseTest {
    private Actions actions;

    public ActionsClassTest() {
        xpathLocators.put("LOGIN_BUTTON", "//nav[@class='container']//div/a[contains(@class, 'login')]");
        xpathLocators.put("PLATFORM_DROPDOWN", "(//div[contains(@class, 'resource')])[1]");
        xpathLocators.put("BOX_A", "//div[@id='column-a']");
        xpathLocators.put("BOX_B", "//div[@id='column-b']");
        xpathLocators.put("GOOGLE_SEARCH_BOX", "//textarea[@aria-label='Search']");
        xpathLocators.put("LAMBDATEST_FOOTER_TEXT", "(//div[@class='container__selenium'])[10]/div/h2");
    }

    @Test(priority = 1)
    public void clickOnAnElement() {
        driver.get(LAMBDATEST_URL);

        actions = new Actions(driver);
        WebElement loginButton = driver.findElement(By.xpath(xpathLocators.get("LOGIN_BUTTON")));
        actions.click(loginButton).perform();

        logger.info(driver.getTitle());
    }

    @Test(priority = 2)
    public void moveTo() {
        driver.get(LAMBDATEST_URL);

        actions = new Actions(driver);
        WebElement platformDropdown = driver.findElement(By.xpath(xpathLocators.get("PLATFORM_DROPDOWN")));
        actions.moveToElement(platformDropdown).perform();
    }

    @Test(priority = 3)
    public void click() {
        driver.get(LAMBDATEST_URL);

        actions = new Actions(driver);
        WebElement loginButton = driver.findElement(By.xpath(xpathLocators.get("LOGIN_BUTTON")));
        actions.moveToElement(loginButton).click().perform();

        logger.info(driver.getTitle());
    }

    @Test(priority = 4)
    public void dragAndDrop() {
        driver.get(HEROKU_DRAG_AND_DROP_URL);

        WebElement boxA = driver.findElement(By.xpath(xpathLocators.get("BOX_A")));
        WebElement boxB = driver.findElement(By.xpath(xpathLocators.get("BOX_B")));

        logger.info("Initial order of boxes    : " + boxA.getText() + ", " + boxB.getText());

        actions = new Actions(driver);
        actions.dragAndDrop(boxA, boxB).perform();

        logger.info("Final order after swapping: " + boxA.getText() + ", " + boxB.getText());
    }

    @Test(priority = 5)
    public void keyDownAndKeyUp() {
        driver.get(GOOGLE_SEARCH_URL);

        WebElement googleSearchBox = driver.findElement(By.xpath(xpathLocators.get("GOOGLE_SEARCH_BOX")));

        actions = new Actions(driver);
        actions
                .moveToElement(googleSearchBox)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("Selenium")
                .keyUp(Keys.SHIFT)
                .perform();

        wait(1);
    }

    @Test(priority = 6)
    public void scroll() {
        driver.get(LAMBDATEST_URL);

        actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath(xpathLocators.get("LAMBDATEST_FOOTER_TEXT")))).perform();

        takeScreenshotOfElement(xpathLocators.get("LAMBDATEST_FOOTER_TEXT"), "Actions class - Scrolling to element");
        logger.info(driver.findElement(By.xpath(xpathLocators.get("LAMBDATEST_FOOTER_TEXT"))).getText());
    }
}
