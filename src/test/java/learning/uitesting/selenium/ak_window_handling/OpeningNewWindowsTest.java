package learning.uitesting.selenium.ak_window_handling;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

/*
 * Selenium considers both "tabs" and "windows" as windows.
 *
 * Using Selenium, we can explicitly open a new window.
 *
 * "driver.switchTo().newWindow(WindowType)" can be used to open a new window.
 * "WindowType" is an enum with 2 constants: "TAB" and "WINDOW" to open a new tab or window respectively.
 */
public class OpeningNewWindowsTest extends WindowHandlingBaseTest {
    @Test(priority = 1)
    public void openNewTab() {
        driver.get(LAMBDATEST_LOGIN_PAGE_URL);
        logger.info(driver.getTitle() + " - " + driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(LAMBDATEST_WINDOW_POPUP_MODAL_URL);
        logger.info(driver.getTitle() + " - " + driver.getWindowHandle());
    }

    @Test(priority = 2)
    public void openNewWindow() {
        driver.get(LAMBDATEST_LOGIN_PAGE_URL);
        logger.info(driver.getTitle() + " - " + driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(LAMBDATEST_WINDOW_POPUP_MODAL_URL);
        logger.info(driver.getTitle() + " - " + driver.getWindowHandle());
    }
}
