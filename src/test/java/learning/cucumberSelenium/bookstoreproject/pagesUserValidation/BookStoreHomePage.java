package learning.cucumberSelenium.bookstoreproject.pagesUserValidation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static learning.cucumberSelenium.ui.UIConstants.*;

public class BookStoreHomePage {
    private final WebDriver driver;

    public BookStoreHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#login")
    private WebElement logInButton;

    @FindBy(css = "#userName")
    private WebElement userNameInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    public void openHomePage() {
        driver.get(BOOK_STORE_HOME_PAGE);
    }

    public BookStoreUserPage enterLogInCredentials(String username, String password) {
        logInButton.click();
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        logInButton.click();
        return new BookStoreUserPage(driver);
    }
}
