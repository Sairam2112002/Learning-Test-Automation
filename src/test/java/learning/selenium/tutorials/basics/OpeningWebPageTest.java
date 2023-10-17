package learning.selenium.tutorials.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static learning.constants.SeleniumProperties.*;

public class OpeningWebPageTest {
    private WebDriver driver;

    @BeforeClass
    private void setUp() {
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(CHROME_ARGUMENT);
        driver = new ChromeDriver(chromeOptions);
    }

    @Test(priority = 1)
    public void openGooglePage() {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void searchInYouTube() {
        driver.get("https://www.youtube.com");
        WebElement searchBox = driver.findElement(By.cssSelector("#search-input>#search"));
        searchBox.sendKeys("Breaking Bad");
        searchBox.submit();
    }

    @AfterClass
    private void quitDriver() {
        driver.quit();
    }
}
