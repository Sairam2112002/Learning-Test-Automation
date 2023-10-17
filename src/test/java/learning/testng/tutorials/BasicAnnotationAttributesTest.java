package learning.testng.tutorials;

import org.testng.Assert;
import org.testng.annotations.Test;

// @Test
// description

public class BasicAnnotationAttributesTest {
    @Test(description = "This test is intended to be Passes")
    public void passingTest() {
        Assert.assertTrue(true);
    }

    @Test(description = "This test is intended to be failed")
    public void failingTest() {
        Assert.fail();
    }
}
