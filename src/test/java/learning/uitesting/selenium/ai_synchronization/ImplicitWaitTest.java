package learning.uitesting.selenium.ai_synchronization;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitTest extends SeleniumBaseTest {
    public ImplicitWaitTest() {
        xpathLocators.put("GOOGLE_SEARCH_BOX", "//textarea[@aria-label='Search']");
    }

    /*
     * Implicit Wait:
     *
     * It specifies the amount of time the driver should wait when searching for an element if it is not immediately present
     * before throwing "NoSuchElementException"
     *
     * Implicit Wait setting is a Global setting and applies to all elements in the script,
     * and it remains in effect for the duration of the WebDriver instance.
     *
     * When an implicit wait is set, the WebDriver will continuously try to locate the element during the specified timeout duration.
     * If the element is not immediately found, the driver will repeatedly poll the DOM for the presence of the element until:
     *     The element is found, or
     *     The specified timeout duration is exceeded, in which case "NoSuchElementException" is thrown
     * The polling interval (how frequently Selenium reattempts to find the element) in implicit wait is fixed and is
     * "500 ms".
     */
    @Test
    public void implicitWaitTest() {
        driver.get(GOOGLE_SEARCH_URL);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement searchBox = driver.findElement(By.xpath(xpathLocators.get("GOOGLE_SEARCH_BOX")));
        searchBox.sendKeys("Selenium");
        searchBox.sendKeys(Keys.RETURN);

        logger.info(driver.getTitle());
    }
}
