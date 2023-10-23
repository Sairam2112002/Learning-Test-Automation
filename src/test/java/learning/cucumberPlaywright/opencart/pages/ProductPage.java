package learning.cucumberPlaywright.opencart.pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class ProductPage {
    private final Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    private static final String PRODUCT_TITLE = "#content>div>div[class='col-sm-4']>h1";
    private static final String BRAND = "#content>div>div[class='col-sm-4']>ul>li>a";
    private static final String SPECIFICATIONS = "#content>div>div[class='col-sm-4']>ul>li";
    private static final String PRICE = "#content>div>div[class='col-sm-4']>ul>li>h2";

    public void printProductPageUrl() {
        System.out.println(page.url());
    }

    /**
     * Verifications
     */
    public void verifyProductTitle(String expectedTitle) {
        assertThat(page.locator(PRODUCT_TITLE)).containsText(expectedTitle);
    }

    public void verifyBrand(String expectedBrand) {
        assertThat(page.locator(BRAND)).containsText(expectedBrand);
    }

    public void verifyProductCode(String expectedProductCode) {
        assertThat(page.locator(SPECIFICATIONS).nth(1)).containsText(expectedProductCode);
    }

    public void verifyRewardPoints(String expectedRewardPoints) {
        assertThat(page.locator(SPECIFICATIONS).nth(2)).containsText(expectedRewardPoints);
    }

    public void verifyPrice(String expectedPrice) {
        assertThat(page.locator(PRICE)).containsText(expectedPrice);
    }
}