package learning.uitesting.selenium.exampleproblems.greenkartvegetables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class GreenCartTest extends GreenKartBaseTest {
    private static final int expectedPriceOfAddedVegetables = 980;

    public GreenCartTest() {
        xpathLocators.put("ALL_VEGETABLE_NAMES", "//div[@class='product']/h4");
        xpathLocators.put("INCREASE_VEGETABLE_BUTTON", "//h4[contains(text(), 'vegetableName')]/following-sibling::div[1]/a[2]");
        xpathLocators.put("VEGETABLE_COUNT", "//h4[contains(text(), 'vegetableName')]/following-sibling::div[1]/input");
        xpathLocators.put("ADD_TO_CART", "//h4[contains(text(), 'vegetableName')]/following-sibling::div[2]/button");
        xpathLocators.put("CART_PRICE", "//div[@class='cart-info']//tr[2]/td[3]");
        xpathLocators.put("CART_ICON", "//a[@class='cart-icon']");
        xpathLocators.put("PROCEED_TO_CHECKOUT_BUTTON", "//div[@class='cart-preview active']/div[@class='action-block']/button");
        xpathLocators.put("CHECKOUT_TOTAL_AMOUNT", "//div[@class='promoWrapper']/following-sibling::span[1]");
        xpathLocators.put("PLACE_ORDER_BUTTON", "//div[@class='promoWrapper']/following-sibling::button");
        xpathLocators.put("COUNTRY_DROPDOWN", "//div[@class='products']//select");
        xpathLocators.put("TERMS_AND_CONDITIONS_CHECKBOX", "//input[@class='chkAgree']");
        xpathLocators.put("COUNTRY_PROCEED_BUTTON", "//input[@class='chkAgree']/following-sibling::button");
        xpathLocators.put("FINAL_SUCCESS_MESSAGE", "//div[@id='root']//div[@class='products']/div");
    }

    private final List<String> requiredVegetables = List.of("Cauliflower", "Cucumber", "Beetroot", "Carrot");

    @Test(priority = 1)
    public void testPageTitle() {
        logger.info("Page title: " + driver.getTitle());
        softAssertions.assertThat(driver.getTitle()).isEqualTo("GreenKart - veg and fruits kart");
    }

    @Test(priority = 2)
    public void selectSpecifiedVegetables() {
        int noOfVegetablesToAdd = 5;

        List<WebElement> vegetableNames = driver.findElements(By.xpath(xpathLocators.get("ALL_VEGETABLE_NAMES")));

        for(WebElement vegetableText: vegetableNames) {
            String vegetableName = vegetableText.getText().replace(" - 1 Kg", "");
            if(requiredVegetables.contains(vegetableName)) {
                for(int i = 1; i <= noOfVegetablesToAdd - 1; i++) {
                    WebElement increaseVegetableButton = driver
                            .findElement(By.xpath(xpathLocators.get("INCREASE_VEGETABLE_BUTTON").replace("vegetableName", vegetableName)));
                    increaseVegetableButton.click();
                }

                WebElement vegetableCountElement = driver
                        .findElement(By.xpath(xpathLocators.get("VEGETABLE_COUNT").replace("vegetableName", vegetableName)));
                int noOfVegetablesAdded = Integer.parseInt(vegetableCountElement.getDomProperty("value"));

                softAssertions.assertThat(noOfVegetablesAdded).isEqualTo(noOfVegetablesToAdd);
                logger.info("Number of " + vegetableName + "s added = " + noOfVegetablesAdded);
            }
        }
    }

    @Test(priority = 3)
    public void addSelectedVegetablesToCart() {
        for(String vegetableName: requiredVegetables) {
            WebElement addToCartButton = driver.findElement(By.xpath(xpathLocators.get("ADD_TO_CART").replace("vegetableName", vegetableName)));
            addToCartButton.click();

            softAssertions.assertThat(addToCartButton.getText()).contains("ADDED");
            logger.info(vegetableName + "s added to cart");
        }
    }

    @Test(priority = 4)
    public void verifyTotalPriceOfAddedVegetables() {
        int totalPriceOfAddedVegetables = Integer.parseInt(driver.findElement(By.xpath(xpathLocators.get("CART_PRICE"))).getText());

        softAssertions.assertThat(totalPriceOfAddedVegetables).isEqualTo(expectedPriceOfAddedVegetables);
        logger.info("Total price of cart = Rs. " + totalPriceOfAddedVegetables);
    }

    @Test(priority = 5)
    public void proceedToCheckout() {
        driver.findElement(By.xpath(xpathLocators.get("CART_ICON"))).click();
        driver.findElement(By.xpath(xpathLocators.get("PROCEED_TO_CHECKOUT_BUTTON"))).click();

        waitForElementToBeVisible(xpathLocators.get("CHECKOUT_TOTAL_AMOUNT"));
        int totalPriceOfAddedVegetables = Integer.parseInt(driver.findElement(By.xpath(xpathLocators.get("CHECKOUT_TOTAL_AMOUNT"))).getText());

        softAssertions.assertThat(totalPriceOfAddedVegetables).isEqualTo(expectedPriceOfAddedVegetables);
        logger.info("Total price at checkout = Rs. " + totalPriceOfAddedVegetables);
    }

    @Test(priority = 6)
    public void placeOrder() {
        driver.findElement(By.xpath(xpathLocators.get("PLACE_ORDER_BUTTON"))).click();

        Select countryDropdown = new Select(driver.findElement(By.xpath(xpathLocators.get("COUNTRY_DROPDOWN"))));
        countryDropdown.selectByValue("India");

        driver.findElement(By.xpath(xpathLocators.get("TERMS_AND_CONDITIONS_CHECKBOX"))).click();

        driver.findElement(By.xpath(xpathLocators.get("COUNTRY_PROCEED_BUTTON"))).click();

        String expectedMessage = "Thank you, your order has been placed successfully" + "\n" + "You'll be redirected to Home page shortly!!";
        String actualMessage = driver.findElement(By.xpath(xpathLocators.get("FINAL_SUCCESS_MESSAGE"))).getText();

        softAssertions.assertThat(actualMessage).isEqualTo(expectedMessage);
        logger.info(actualMessage.replace("\n", " "));
    }
}
