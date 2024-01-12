package learning.cucumberselenium.general.setup.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserDriver implements Drivers {
    @Override
    public WebDriver createDriver(boolean isHeadless) {
        WebDriverManager.chromedriver().setup();

        if(isHeadless) {
            return new ChromeDriver(new ChromeOptions().addArguments("--headless"));
        } else {
            return new ChromeDriver();
        }
    }
}
