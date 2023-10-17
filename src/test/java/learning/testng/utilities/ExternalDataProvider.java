package learning.testng.utilities;

import org.testng.annotations.DataProvider;

public class ExternalDataProvider {
    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][] {
                {1, 2, 3},
                {2, 3, 5},
                {3, 4, 7},
                {4, 5, 9}
        };
    }
}
