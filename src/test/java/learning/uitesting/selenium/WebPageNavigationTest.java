package learning.uitesting.selenium;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.testng.annotations.Test;

public class WebPageNavigationTest extends SeleniumBaseTest {
    @Test
    public void navigateDriver() {
        /*
         * Navigate to example.com
         *
         * driver().navigate.to() method is similar to driver.get() method
         *
         * But is part of the Navigation interface,
         * which allows additional navigation options such as back, forward, and refresh.
         */
        driver.navigate().to(EXAMPLE_URL);
        System.out.println("Title of page: " + driver.getTitle());  // Title of page: Example Domain

        // Navigate to another example page like wikipedia
        driver.navigate().to(WIKIPEDIA_URL);
        System.out.println("Title of new page: " + driver.getTitle()); // Title of page: Wikipedia

        // Navigate back to example.com
        driver.navigate().back();
        System.out.println("Title after going back: " + driver.getTitle()); // Title of page: Example Domain

        // Navigate forward to Wikipedia
        driver.navigate().forward();
        System.out.println("Title after going forward: " + driver.getTitle()); // Title of page: Wikipedia

        // Refresh the Wikipedia Page
        driver.navigate().refresh();
        System.out.println("Title after refresh: " + driver.getTitle()); // Title of page: Wikipedia
    }
}
