package learning.cucumberselenium.nopcommerce.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import learning.cucumberselenium.general.setup.HooksMethods;

public class HooksNOPCommerceSelenium extends HooksMethods {
    @Before
    public void before(Scenario scenario) {
        beforeMethod(scenario);
    }

    @After
    public void after(Scenario scenario) {
        afterMethod(scenario);
    }
}
