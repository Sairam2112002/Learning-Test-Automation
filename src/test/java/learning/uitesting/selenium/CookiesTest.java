package learning.uitesting.selenium;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

public class CookiesTest extends SeleniumBaseTest {
    @Test(priority = 1)
    public void getAllCookies() {
        driver.get(MDN_WEB_DOCS_URL);
        Set<Cookie> allCookies = driver.manage().getCookies();

        for(Cookie cookie: allCookies) {
            logger.info(cookie.getName() + ": " + cookie.getValue());
        }
    }

    @Test(priority = 2)
    public void addCookie() {
        Cookie cookie = new Cookie("testCookieName", "testCookieValue");
        driver.manage().addCookie(cookie);
        logger.info(driver.manage().getCookieNamed("testCookieName"));
    }

    @Test(priority = 3)
    public void gettingSpecificCookie() {
        logger.info(driver.manage().getCookieNamed("testCookieName"));
    }

    @Test(priority = 4)
    public void deletingSpecificCookie() {
        driver.manage().deleteCookieNamed("testCookieName");
        logger.info(driver.manage().getCookieNamed("testCookieName"));
    }

    @Test(priority = 5)
    public void DeletingAllCookies() {
        driver.manage().deleteAllCookies();
    }
}
