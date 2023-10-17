package learning.testng.tutorials;

import learning.testng.utilities.ExternalDataProvider;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    // Internal Data Provider i.e. in the same class
    @Test(dataProvider = "dataProvider")
    public void dataProviderInThisClass(int a, int b, int expectedResult) {
        int result = a - b;
        Assert.assertEquals(result, expectedResult);
    }

    //External Data Provider i,e, in the different class
    @Test(dataProvider = "dataProvider", dataProviderClass = ExternalDataProvider.class)
    public void dataProviderInExternalClass(int a, int b, int expectedResult) {
        int result = a + b;
        Assert.assertEquals(result, expectedResult);
    }

    @DataProvider(name = "dataProvider")
    private Object[][] dataProvider() {
        return new Object[][] {
                {1, 2, -1},
                {2, 3, -1},
                {3, 4, -1},
                {4, 5, -1}
        };
    }
}
