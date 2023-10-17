package learning.cucumberSelenium.bookstoreproject.stepdefs.userValidation;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import learning.cucumberSelenium.bookstoreproject.pages.userValidation.BookStoreHomePage;
import learning.cucumberSelenium.bookstoreproject.pages.userValidation.BookStoreUserPage;
import learning.driverfactory.Driver;
import learning.driverfactory.DriverFactory;
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