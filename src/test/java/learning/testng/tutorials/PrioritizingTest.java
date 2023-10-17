package learning.testng.tutorials;

import org.testng.Assert;
import org.testng.annotations.Test;

// priority

public class PrioritizingTest {
    @Test(priority = 1)
    public void test1() {
        Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void test2() {
        Assert.assertTrue(true);
    }

    @Test(priority = 3)
    public void test3() {
        Assert.assertTrue(true);
    }

    @Test(priority = 4)
    public void test4() {
        Assert.assertTrue(true);
    }

    @Test(priority = 5)
    public void test5() {
        Assert.assertTrue(true);
    }
}
