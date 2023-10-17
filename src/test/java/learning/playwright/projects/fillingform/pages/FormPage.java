package learning.playwright.projects.fillingform.pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class FormPage {
    private final Page page;

    private static final String FORM_PAGE_URI = "https://sairam2112002.github.io/survey-form/";

    public FormPage(Page page) {
        this.page = page;
    }

    String nameBox = "css=#name";
    String emailBox = "css=#email";
    String ageBox = "css=#number";
    String roleDropdown = "css=#dropdown";
    String recommendationRadioButton = "css=input[value='Definitely']";
    String improvementCheckbox = "css=input[value='City Meetups']";
    String suggestionsBox = "css=#textarea";

    // Open Form Page
    public void openFormPage() {
        page.navigate(FORM_PAGE_URI);
    }

    // Filling Form
    public FormPage enterDetails() {
        return enterName()
                .enterEmail()
                .enterAge()
                .selectRole()
                .selectRecommendation()
                .selectImprovements()
                .enterSuggestions();
    }

    private FormPage enterName() {
        page.locator(nameBox).fill("Harry Potter");
        return new FormPage(page);
    }

    private FormPage enterEmail() {
        page.locator(emailBox).fill("hogwarts@gmail.com");
        return new FormPage(page);
    }

    private FormPage enterAge() {
        page.locator(ageBox).fill("20");
        return new FormPage(page);
    }

    private FormPage selectRole() {
        page.locator(roleDropdown).selectOption("Full Time Job");
        return new FormPage(page);
    }

    private FormPage selectRecommendation() {
        page.locator(recommendationRadioButton).check();
        return new FormPage(page);
    }

    private FormPage selectImprovements() {
        page.locator(improvementCheckbox).check();
        return new FormPage(page);
    }

    private FormPage enterSuggestions() {
        page.locator(suggestionsBox).fill("FreeCodeCamp is a great place to learn");
        return new FormPage(page);
    }

    // Verifications
    public void verifyName(String expectedName) {
        assertThat(page.locator(nameBox)).hasValue(expectedName);
    }

    public void verifyEmail(String expectedEmail) {
        assertThat(page.locator(emailBox)).hasValue(expectedEmail);
    }

    public void verifyAge(String expectedAge) {
        assertThat(page.locator(ageBox)).hasValue(expectedAge);
    }

    public void verifyRole() {
        // This is a statement used in JavaScript
        // return (page.evaluate("document.querySelector('#dropdown').value").toString()).equals(expectedRole);

        assertThat(page.locator(roleDropdown)).hasValue("Full Time Job");
    }

    public void verifyRecommendation() {
        assertThat(page.locator(recommendationRadioButton)).isChecked();
    }

    public void verifyImprovements() {
        assertThat(page.locator(improvementCheckbox)).isChecked();
    }

    public void verifySuggestions(String expectedSuggestions) {
        assertThat(page.locator(suggestionsBox)).hasValue(expectedSuggestions);
    }
}
