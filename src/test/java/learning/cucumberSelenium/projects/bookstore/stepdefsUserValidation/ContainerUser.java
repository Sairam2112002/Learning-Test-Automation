package learning.cucumberSelenium.projects.bookstore.stepdefsUserValidation;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import learning.cucumberSelenium.projects.bookstore.pagesUserValidation.BookStoreHomePage;
import learning.cucumberSelenium.projects.bookstore.pagesUserValidation.BookStoreUserPage;
import learning.utilities.driverfactoryselenium.Driver;
import learning.utilities.driverfactoryselenium.DriverFactory;
import learning.selenium.exceptions.BrowserNotFoundException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ContainerUser {
    protected static WebDriver driver;
    protected static Response response;
    protected static BookStoreHomePage homePage;
    protected static BookStoreUserPage userPage;

    protected static String createdUsername;
    protected static String createdPassword;

    @Before("@userValidation")
    public static void setUp() throws BrowserNotFoundException, IOException {
        Driver browserType = DriverFactory.createDriver();
        driver = browserType.getDriver();
        driver.manage().window().maximize();
        homePage = new BookStoreHomePage(driver);
    }

    @After("@userValidation")
    public static void quitDriver() {
        driver.quit();
    }
}