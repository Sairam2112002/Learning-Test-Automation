package learning.selenium.tutorials;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SeleniumBase {
    protected static WebDriver driver;
    protected static Select select;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        SeleniumAssertion.initializeSoftAssertions();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        SeleniumAssertion.assertAll();
    }
}
