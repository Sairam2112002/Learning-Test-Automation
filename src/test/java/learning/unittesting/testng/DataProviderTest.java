package learning.unittesting.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    private static final Logger LOGGER = LogManager.getLogger(DataProviderTest.class);

    @Test(dataProvider = "Cars Data Provider", groups = {"group.car"})
    public void dataProviderTestCar(String carName, String companyName) {
        LOGGER.info(carName + " : " + companyName);
    }

    @Test(dataProvider = "Aircrafts Data Provider", dataProviderClass = DataProviderClass.class, groups = {"group.aircraft"})
    public void dataProviderTestAircraft(String aircraftName, String companyName) {
        LOGGER.info(aircraftName + " : " + companyName);
    }

    @DataProvider(name = "Cars Data Provider")
    private Object[][] carsDataProvider() {
        return new Object[][] {
                {"Polo", "Volkswagen"}, {"Lancer", "Mitsubishi"}, {"RX-8", "Mazda"}, {"Gallardo", "Lamborghini"},
                {"C6", "Chevrolet Corvette"}, {"Viper", "Dodge"}, {"DB9", "Aston Martin"}, {"Agera", "Koenigsegg"}
        };
    }
}
