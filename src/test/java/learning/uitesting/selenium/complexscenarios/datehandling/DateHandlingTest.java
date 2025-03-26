package learning.uitesting.selenium.complexscenarios.datehandling;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class DateHandlingTest extends DateHandlingBaseTest {
    private static final Map<String, String> xpathLocators = new HashMap<>();

    public DateHandlingTest() {
        xpathLocators.put("green kart delivery date button", "//button[@class='react-date-picker__calendar-button react-date-picker__button']");
        xpathLocators.put("green kart delivery date selected", "//div[@class='react-date-picker__inputGroup']/input");
        xpathLocators.put("green kart calendar label", "//div[@class='react-calendar__navigation']/button[3]/span");
        xpathLocators.put("green kart calendar decrease year button", "//div[@class='react-calendar__navigation']/button[1]");
        xpathLocators.put("green kart calendar decrease month button", "//div[@class='react-calendar__navigation']/button[2]");
        xpathLocators.put("green kart calendar increase month button", "//div[@class='react-calendar__navigation']/button[4]");
        xpathLocators.put("green kart calendar increase year button", "//div[@class='react-calendar__navigation']/button[5]");
        xpathLocators.put("green kart calendar date button", "//div[@class='react-calendar__month-view__days']//abbr[@aria-label='MMMM d, yyyy']");
    }

    @Test(priority = 1, dataProvider = "dates provider")
    public void selectingDateFromGreenKartTopDeals(int day, int month, int year) throws InterruptedException {
        driver.get(RAHUL_SHETTY_ACADEMY_GREEN_KART_TOP_DEALS_URL);

        WebElement deliveryDateButton = driver.findElement(By.xpath(xpathLocators.get("green kart delivery date button")));
        deliveryDateButton.click();

        try {
            LocalDate localDate = LocalDate.of(year, month, day);

            /*
             * Converting current month and date from UI Calendar to integers
             */
            String currentMonthYear = driver.findElement(By.xpath(xpathLocators.get("green kart calendar label"))).getText();
            int currentYear = Integer.parseInt(currentMonthYear.split(" ")[1]);
            String currentMonthString = currentMonthYear.split(" ")[0];
            int currentMonth = Month.valueOf(currentMonthString.toUpperCase()).getValue();

            /*
             * Selecting Year
             */
            if(year < currentYear) {
                WebElement decreaseYearButton = driver.findElement(By.xpath(xpathLocators.get("green kart calendar decrease year button")));

                for(int i = 1; i <= (currentYear - year); i++) {
                    decreaseYearButton.click();
                }
            } else if(year > currentYear) {
                WebElement increaseYearButton = driver.findElement(By.xpath(xpathLocators.get("green kart calendar increase year button")));

                for(int i = 1; i <= (year - currentYear); i++) {
                    increaseYearButton.click();
                }
            }

            /*
             * Selecting Month
             */
            if(month < currentMonth) {
                WebElement decreaseMonthButton = driver.findElement(By.xpath(xpathLocators.get("green kart calendar decrease month button")));

                for(int i = 1; i <= (currentMonth - month); i++) {
                    decreaseMonthButton.click();
                }
            } else if(month > currentMonth) {
                WebElement increaseMonthButton = driver.findElement(By.xpath(xpathLocators.get("green kart calendar increase month button")));

                for(int i = 1; i <= (month - currentMonth); i++) {
                    increaseMonthButton.click();
                }
            }

            /*
             * Converting the entire date to required format to use it locate the required day web element
             */
            DateTimeFormatter dateTimeFormatterToSelectDate = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            String dateToSelect = localDate.format(dateTimeFormatterToSelectDate);

            /*
             * Locating and selecting the required date web element
             */
            String dateElementToSelectLocator =  xpathLocators.get("green kart calendar date button").replace("MMMM d, yyyy", dateToSelect);
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement dateElementToSelect = webDriverWait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dateElementToSelectLocator)));
            dateElementToSelect.click();

            /*
             * Converting the input date into required format to assert with the date selected in the UI
             */
            DateTimeFormatter dateTimeFormatterForAssertion = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String expectedDate = localDate.format(dateTimeFormatterForAssertion);
            String actualSelectedDate = driver.findElement(By.xpath(xpathLocators.get("green kart delivery date selected"))).getDomAttribute("value");

            assertThat(actualSelectedDate).isEqualTo(expectedDate);
        } catch(DateTimeException dateTimeException) {
            logger.error(dateTimeException.getMessage());

            fail("Provided date is invalid");
        }
        Thread.sleep(2000);
    }

    @DataProvider(name = "dates provider")
    public Object[][] datesProvider() {
        return new Object[][] {
                {1, 1, 2020},
                {2, 12, 2024}
        };
    }
}
