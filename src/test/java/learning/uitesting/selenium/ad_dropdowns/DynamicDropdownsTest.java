package learning.uitesting.selenium.ad_dropdowns;

import learning.uitesting.selenium.utilities.SeleniumBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DynamicDropdownsTest extends SeleniumBaseTest {
    public DynamicDropdownsTest() {
        xpathLocators.put("DEPARTURE_CITY_DROPDOWN", "//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
        xpathLocators.put("DEPARTURE_CITY_HYDERABAD_OPTION", "//a[@value='HYD']");
        xpathLocators.put("ARRIVAL_CITY_VIJAYAWADA_OPTION", "(//a[@value='VGA'])[2]");
        xpathLocators.put("DEPART_DATE_MAY_10", "(//table[@class='ui-datepicker-calendar'])[1]//tbody//tr[2]//td[6]");
    }

    @Test(priority = 1)
    public void setUp() {
        driver.get(RAHUL_SHETTY_ACADEMY_DROPDOWN_PRACTICE);
    }

    @Test(priority = 2)
    public void dynamicDropdowns() {
        driver.findElement(By.xpath(xpathLocators.get("DEPARTURE_CITY_DROPDOWN"))).click();

        waitForElementToBeVisible(xpathLocators.get("DEPARTURE_CITY_HYDERABAD_OPTION"));
        driver.findElement(By.xpath(xpathLocators.get("DEPARTURE_CITY_HYDERABAD_OPTION"))).click();

        waitForElementToBeVisible(xpathLocators.get("ARRIVAL_CITY_VIJAYAWADA_OPTION"));
        driver.findElement(By.xpath(xpathLocators.get("ARRIVAL_CITY_VIJAYAWADA_OPTION"))).click();

        waitForElementToBeVisible(xpathLocators.get("DEPART_DATE_MAY_10"));
        driver.findElement(By.xpath(xpathLocators.get("DEPART_DATE_MAY_10"))).click();
    }
}
