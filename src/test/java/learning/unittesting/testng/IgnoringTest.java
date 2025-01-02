package learning.unittesting.testng;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoringTest {
    @Test
    public void ignoringTest1() {
        Assert.assertTrue(true);
    }

    @Ignore
    @Test
    public void ignoringTest2() {
        Assert.assertTrue(true);
    }
}
