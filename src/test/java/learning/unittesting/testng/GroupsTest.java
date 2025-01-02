package learning.unittesting.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = {"main group"})
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

    @Test(groups = {"group.group1.1"})
    public void groupTest4() {
        Assert.assertTrue(true);
    }

    @Test(groups = {"group.group1.2"})
    public void groupTest5() {
        Assert.assertTrue(true);
    }

    @Test(groups = {"group.group2.1"})
    public void groupTest6() {
        Assert.assertTrue(true);
    }

    @Test(groups = {"group.group2.2"})
    public void groupTest7() {
        Assert.assertTrue(true);
    }
}
