package learning.selenium.tutorials;

import org.assertj.core.api.SoftAssertions;

public class SeleniumAssertion {
    protected static SoftAssertions softAssertions;

    public static void initializeSoftAssertions() {
        softAssertions = new SoftAssertions();
    }

    public static void assertAll() {
        softAssertions.assertAll();
    }
}
