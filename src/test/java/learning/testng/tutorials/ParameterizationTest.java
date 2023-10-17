package learning.testng.tutorials;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationTest {
    @Test(priority = 1)
    @Parameters({"nameValue"})
    public void test(String name) {
        System.out.println("My name is " + name);
    }

    @Test(priority = 2)
    @Parameters({"nameValue2"})
    public void optionalParameter(@Optional("Ram") String name) {
        System.out.println("My name is " + name);
    }
}
