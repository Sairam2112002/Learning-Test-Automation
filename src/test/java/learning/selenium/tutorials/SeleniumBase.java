package learning.selenium.tutorials;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.List;

public class SeleniumBase {
    protected static SoftAssertions softAssertions;
    protected static WebDriver driver;
    protected static Select select;
    protected static Actions actions;
    protected static Alert alert;
    protected static List<String> windowHandles;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        softAssertions = new SoftAssertions();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public void openBaseUri(String uri) {
        driver.get(uri);
    }
}
