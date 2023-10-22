package learning.cucumberSelenium.projects.bookstore.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import learning.cucumberSelenium.projects.bookstore.pages.BookStoreHomePage;
import learning.cucumberSelenium.projects.bookstore.pages.BookStoreUserPage;
import learning.selenium.exceptions.DriverNotFoundException;
import learning.utilities.driverfactoryselenium.Driver;
import learning.utilities.driverfactoryselenium.DriverFactory;
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
    public static void setUp() throws IOException, DriverNotFoundException {
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