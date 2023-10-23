package learning.cucumberPlaywright.fillingform.pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FillingFormPage {
    private final Page page;

    private static final String FORM_PAGE_URI = "https://sairam2112002.github.io/survey-form/";

    public FillingFormPage(Page page) {
        this.page = page;
    }

    private final String nameBox = "css=#name";
    private final String emailBox = "css=#email";
    private final String ageBox = "css=#number";
    private final String roleDropdown = "css=#dropdown";
    private final String recommendationRadioButton = "css=input[value='Definitely']";
    private final String improvementCheckbox = "css=input[value='City Meetups']";
    private final String suggestionsBox = "css=#textarea";

    // Open Form Page
    public void openFormPage() {
        page.navigate(FORM_PAGE_URI);
    }

    // Filling Form
    public FillingFormPage enterDetails() {
        return enterName()
                .enterEmail()
                .enterAge()
                .selectRole()
                .selectRecommendation()
                .selectImprovements()
                .enterSuggestions();

    }

    private FillingFormPage enterName() {
        page.locator(nameBox).fill("Harry Potter");
        return new FillingFormPage(page);
    }

    private FillingFormPage enterEmail() {
        page.locator(emailBox).fill("hogwarts@gmail.com");
        return new FillingFormPage(page);
    }

    private FillingFormPage enterAge() {
        page.locator(ageBox).fill("20");
        return new FillingFormPage(page);
    }

    private FillingFormPage selectRole() {
        page.locator(roleDropdown).selectOption("Full Time Job");
        return new FillingFormPage(page);
    }

    private FillingFormPage selectRecommendation() {
        page.locator(recommendationRadioButton).check();
        return new FillingFormPage(page);
    }

    private FillingFormPage selectImprovements() {
        page.locator(improvementCheckbox).check();
        return new FillingFormPage(page);
    }

    private FillingFormPage enterSuggestions() {
        page.locator(suggestionsBox).fill("FreeCodeCamp is a great place to learn");
        return new FillingFormPage(page);
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

    public void verifyRole(String expectedRole) {
        // This is a statement used in JavaScript
        // return (page.evaluate("document.querySelector('#dropdown').value").toString()).equals(expectedRole);

        assertThat(page.locator(roleDropdown)).hasValue(expectedRole);
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
