package learning.cucumberselenium.general.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebActionImplementations {
    public void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getText(WebElement element) {
        return element.getText();
    }
}
