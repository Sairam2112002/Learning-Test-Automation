package learning.uitesting.selenium.af_radio_buttons;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RadioButtonsTest extends SeleniumBaseTest {
    public RadioButtonsTest() {
        xpathLocators.put("RADIO_BUTTON_MALE", "(//input[@type='radio'])[1]");
        xpathLocators.put("RADIO_BUTTON_GET_VALUE_BUTTON", "//button[@id='buttoncheck']");
        xpathLocators.put("RADIO_BUTTON_MESSAGE", "(//input[@type='radio'])[1]//following::p[1]");
    }

    @Test(priority = 1)
    public void setUp() {
        driver.get(LAMBDATEST_RADIO_BUTTONS_URL);
    }

    @Test(priority = 2)
    public void radioButtons() {
        driver.findElement(By.xpath(xpathLocators.get("RADIO_BUTTON_MALE"))).click();
        driver.findElement(By.xpath(xpathLocators.get("RADIO_BUTTON_GET_VALUE_BUTTON"))).click();

        logger.info(driver.findElement(By.xpath(xpathLocators.get("RADIO_BUTTON_MESSAGE"))).getText());
    }
}
