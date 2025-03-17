package learning.uitesting.selenium;

import learning.uitesting.selenium.basetests.SeleniumBaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends SeleniumBaseTest {
    private JavascriptExecutor jsExecutor;
    private WebElement maleRadioButton;

    @Test(priority = 1)
    public void findElementWithXPath() {
        driver.get(LAMBDATEST_RADIO_BUTTONS_URL);

        jsExecutor = (JavascriptExecutor) driver;
        String maleRadioButtonXPath = "(//input[@type='radio' and @value='Male'])[1]";
        maleRadioButton = (WebElement) jsExecutor
                .executeScript("return document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;", maleRadioButtonXPath);

        if(maleRadioButton != null) {
            maleRadioButton.click();
            logger.info(maleRadioButton.isSelected());
        }
    }

    @Test(priority = 2)
    public void finElementUsingCSSSelector() {
        driver.get(LAMBDATEST_RADIO_BUTTONS_URL);

        jsExecutor = (JavascriptExecutor) driver;
        String maleRadioButtonCSSSelector = "input[type='radio'][value='Male']";
        maleRadioButton = (WebElement) jsExecutor
                .executeScript("return document.querySelector(arguments[0])", maleRadioButtonCSSSelector);

        if(maleRadioButton != null) {
            maleRadioButton.click();
            logger.info(maleRadioButton.isSelected());
        }
    }

    /*
     * Along with element's name, we can also find elements using id, class name and tag name using the following methods:
     * document.getElementById()
     * document.getElementsByClassName()
     * document.getElementsByTagName()
     *
     * We can notice that for using id the method name contains "getElement", but for other approaches, the method
     * name contains "getElements" because id is unique in dom i.e. it corresponds to a single element
     * And class, tag and name can have multiple corresponding elements
     *
     * When we get multiple elements, we can specify the index at the end to extract a specific element
     */
    @Test(priority = 3)
    public void findElementUsingName() {
        driver.get(LAMBDATEST_RADIO_BUTTONS_URL);;

        jsExecutor = (JavascriptExecutor)driver;
        maleRadioButton = (WebElement) jsExecutor
                .executeScript("return document.getElementsByName('optradio')[0]");

        if(maleRadioButton != null) {
            maleRadioButton.click();
            logger.info(maleRadioButton.isSelected());
        }
    }

    @Test(priority = 4)
    public void enteringTextAndGettingTheValueOfAField() {
        driver.get(LAMBDATEST_INPUT_FORM_URL);

        jsExecutor = (JavascriptExecutor) driver;
        String nameFieldCSSSelector = "input#name";
        jsExecutor
                .executeScript("document.querySelector(arguments[0]).value='Test Name'", nameFieldCSSSelector);

        String valueEnteredInNameField;
        valueEnteredInNameField = (String) jsExecutor
                .executeScript("return document.querySelector(arguments[0]).value", nameFieldCSSSelector);
        logger.info(valueEnteredInNameField);
    }
}
