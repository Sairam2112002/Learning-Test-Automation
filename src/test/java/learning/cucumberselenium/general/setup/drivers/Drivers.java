package learning.cucumberselenium.general.setup.drivers;

import org.openqa.selenium.WebDriver;

public interface Drivers {
    WebDriver createDriver(boolean isHeadless);
}
