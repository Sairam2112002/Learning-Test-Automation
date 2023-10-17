package learning.driverfactory.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import learning.driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyEdgeDriver implements Driver {
    @Override
    public WebDriver getDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
