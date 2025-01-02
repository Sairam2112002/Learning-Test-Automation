package learning.unittesting.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {
    public static final Logger LOGGER = LogManager.getLogger(AnnotationsTest.class);

    // Before Annotations <------------------------------------------------------------------>

    @BeforeSuite
    public void beforeSuite() {
        LOGGER.info("@BeforeSuite is executed before the start of Suite");
    }

    @BeforeTest
    public void beforeTest() {
        LOGGER.info("@BeforeTest is executed before the start of each Test");
    }

    @BeforeGroups(groups = {"group1", "group2", "group3", "group4"})
    public void beforeGroups() {
        LOGGER.info("@BeforeGroups is executed before the start of each specified Group");
    }

    @BeforeClass
    public void beforeClass() {
        LOGGER.info("@BeforeClass is executed before the start of current Test Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        LOGGER.info("@BeforeMethod is executed before the start of each Test Method");
    }

    // After Annotations <------------------------------------------------------------------>

    @AfterSuite
    public void afterSuite() {
        LOGGER.info("@AfterSuite is executed after the end of Suite");
    }

    @AfterTest
    public void afterTest() {
        LOGGER.info("@AfterTest is executed after the end of each Test");
    }

    @AfterGroups(groups = {"group1", "group2", "group3", "group4"})
    public void afterGroups() {
        LOGGER.info("@AfterGroups is executed after the end of all specified Groups");
        /*
         In this example, we have giver four groups for @AfterGroups. Now, this method is executed after the
         last method of last group from the above groups is executed
         */
    }

    @AfterSuite
    public void afterClass() {
        LOGGER.info("@AfterClass is executed after the end of current Test Class");
    }

    @AfterMethod
    public void afterMethod() {
        LOGGER.info("@AfterMethod is executed after the end of each Test Method");
    }

    // Test Methods <------------------------------------->

    @Test(groups = {"group1"})
    public void groupTest1() {
        Assert.assertTrue(true);
        LOGGER.info("method = groupTest1; group = group1");
    }

    @Test(groups = {"group1"})
    public void groupTest2() {
        Assert.assertTrue(true);
        LOGGER.info("method = groupTest2; group = group1");
    }

    @Test(groups = {"group2"})
    public void groupTest3() {
        Assert.assertTrue(true);
        LOGGER.info("method = groupTest3; group = group2");
    }

    @Test(groups = {"group2"})
    public void groupTest4() {
        Assert.assertTrue(true);
        LOGGER.info("method = groupTest4; group = group2");
    }

    @Test(groups = {"group3"})
    public void groupTest5() {
        Assert.assertTrue(true);
        LOGGER.info("method = groupTest5; group = group3");
    }

    @Test(groups = {"group3"})
    public void groupTest6() {
        Assert.assertTrue(true);
        LOGGER.info("method = groupTest6; group = group3");
    }

    @Test(groups = {"group4"})
    public void groupTest7() {
        Assert.assertTrue(true);
        LOGGER.info("method = groupTest7; group = group4");
    }

    @Test(groups = {"group4"})
    public void groupTest8() {
        Assert.assertTrue(true);
        LOGGER.info("method = groupTest8; group = group4");
    }
}
