package learning.cucumberbdd.basics.stepdefinitions;

import io.cucumber.java.*;

public class CucumberBasicsHooks {
    // Step Hooks
    @BeforeStep
    public void beforeStep() {
        System.out.println("@BeforeStep is executed before each step");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("@AfterStep is executed after each step");
    }

    // Scenario Hooks
    @Before
    public void before() {
        System.out.println("@Before is executed before first step each scenario");
    }

    @After
    public void after() {
        System.out.println("@After is executed after the last step of each scenario");
    }

    // Global Hooks
    @BeforeAll
    public static void beforeAll() {
        System.out.println("@BeforeAll is executed before any scenario is started");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("@AfterAll is executed after all scenarios are executed");
    }
}
