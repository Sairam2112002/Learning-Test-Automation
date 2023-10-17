package learning.testng.tutorials;

import org.testng.Assert;
import org.testng.annotations.Test;

// enabled

public class EnabledTest {
    @Test
    public void test1() {
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void test2() {
        Assert.assertTrue(true);
    }

    @Test
    public void test3() {
        Assert.assertTrue(true);
    }
}
