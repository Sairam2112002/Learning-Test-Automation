package learning.uitesting.selenium.ak_window_handling;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

/*
 * Selenium considers both "tabs" and "windows" as windows.
 *
 * getWindowHandle() returns the window handle of current window
 * getWindowHandles() returns the window handles of all opened windows as a LinkedHashSet
 *
 * "driver.switchTo().window(windowHandle)" can be used to switch to a window using its window handle.
 */
public class WindowHandlesTest extends WindowHandlingBaseTest {
    public WindowHandlesTest() {
        xpathLocators.put("TERMS_OF_SERVICE_LINK", "(//div[contains(@class, 'mt-20')])[4]/p/a[1]");
        xpathLocators.put("PRIVACY_POLICY_LINK", "(//div[contains(@class, 'mt-20')])[4]/p/a[2]");
        xpathLocators.put("COOKIE_POLICY_LINK", "(//div[contains(@class, 'mt-20')])[4]/p/a[3]");
        xpathLocators.put("FOLLOW_ALL_LINK", "(//div[contains(@class, 'mt-30')]/div)[5]/a");
    }

    @Test(priority = 1)
    public void getWindowHandle() {
        driver.get(LAMBDATEST_LOGIN_PAGE_URL);

        String windowHandle = driver.getWindowHandle();
        logger.info(windowHandle);
    }

    @Test(priority = 2)
    public void getWindowHandles() {
        driver.get(LAMBDATEST_LOGIN_PAGE_URL);

        driver.findElement(By.xpath(xpathLocators.get("TERMS_OF_SERVICE_LINK"))).click();
        driver.findElement(By.xpath(xpathLocators.get("PRIVACY_POLICY_LINK"))).click();
        driver.findElement(By.xpath(xpathLocators.get("COOKIE_POLICY_LINK"))).click();

        Set<String> windowHandles = driver.getWindowHandles();

        for(String windowHandle: windowHandles) {
            logger.info(windowHandle);
        }
    }

    @Test(priority = 3)
    public void switchingToDifferentTabs() {
        driver.get(LAMBDATEST_LOGIN_PAGE_URL);

        driver.findElement(By.xpath(xpathLocators.get("TERMS_OF_SERVICE_LINK"))).click();
        driver.findElement(By.xpath(xpathLocators.get("PRIVACY_POLICY_LINK"))).click();
        driver.findElement(By.xpath(xpathLocators.get("COOKIE_POLICY_LINK"))).click();

        Set<String> windowHandles = driver.getWindowHandles();

        for(String windowHandle: windowHandles) {
            driver.switchTo().window(windowHandle);
            logger.info(driver.getTitle() + " - " + windowHandle);
        }
    }

    @Test(priority = 4)
    public void switchingToDifferentWindows() {
        driver.get(LAMBDATEST_WINDOW_POPUP_MODAL_URL);

        driver.findElement(By.xpath(xpathLocators.get("FOLLOW_ALL_LINK"))).click();

        Set<String> windowHandles = driver.getWindowHandles();

        for(String windowHandle: windowHandles) {
            driver.switchTo().window(windowHandle);
            logger.info(driver.getTitle() + " - " + windowHandle);
        }
    }
}