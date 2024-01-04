package learning.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsTest {
    @Test(groups = {"group.1"})
    public void groupTest1() {
        Assert.assertTrue(true);
    }

    @Test(groups = {"group.2"})
    public void groupTest2() {
        Assert.assertTrue(true);
    }

    @Test(groups = {"group.3"})
    public void groupTest3() {
        Assert.assertTrue(true);
    }

}
