package learning.uitesting.selenium.ab_basic_webdriver_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicWebDriverMethodsTest {
    private static WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void openUrl() {
        /*
         * Load a new web page in the current browser window.
         */
        driver.get("https://www.lambdatest.com/selenium-playground/");
    }

    @Test(priority = 2)
    public void getDriverData() {
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
    }

    @AfterClass
    public void tearDown() {
        /*
         * Close the current window (tabs), quitting the browser if it's the last window currently open
         */
        driver.close();

        /*
         * Quits this driver, closing every associated window
         */
        driver.quit();
    }
}
