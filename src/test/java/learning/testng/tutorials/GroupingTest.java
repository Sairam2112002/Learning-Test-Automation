package learning.testng.tutorials;

import org.testng.annotations.Test;

// groups

public class GroupingTest {
    @Test(groups = "sanity")
    public void test1() {
        System.out.println("This is a Sanity Test");
    }

    @Test(groups = "regression")
    public void test2() {
        System.out.println("This is a Regression Test");
    }

    @Test(groups = "sanity")
    public void test3() {
        System.out.println("This is a Sanity Test");
    }

    @Test(groups = "regression")
    public void test4() {
        System.out.println("This is a Regression Test");
    }

    @Test(groups = {"sanity", "regression"})
    public void test5() {
        System.out.println("This is both Sanity and Regression Test");
    }
}
