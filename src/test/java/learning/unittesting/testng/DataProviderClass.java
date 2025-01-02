package learning.unittesting.testng;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "Aircrafts Data Provider")
    public Object[][] aircraftsDataProvider() {
        return new Object[][] {
                {"747", "Boeing"}, {"A380", "Airbus"}, {"G800", "Gulfstream"}, {"Rafale", "Dassault Aviation"},
                {"B-21 Raider", "Northrop Grumman"}, {"SR-71 Blackbird", "Lockheed Corporation"}, {"F-22 Raptor", "Lockheed Martin"}, {"An-225 Mriya", "Antonov Design Bureau"}
        };
    }
}
