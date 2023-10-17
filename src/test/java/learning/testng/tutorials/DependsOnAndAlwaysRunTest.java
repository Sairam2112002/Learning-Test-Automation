package learning.testng.tutorials;

import org.testng.Assert;
import org.testng.annotations.Test;

// dependsOnMethods
// dependsOnGroups
// alwaysRun

public class DependsOnAndAlwaysRunTest {
    @Test(groups = {"car"})
    public void startCar() {
        System.out.println("Car is started");
    }

    @Test(groups = {"car"}, dependsOnMethods = {"startCar"})
    public void driverCar() {
        System.out.println("Car is being driven");
    }

    @Test(groups = {"car"}, dependsOnMethods = {"driverCar"})
    public void stopCar() {
        System.out.println("Car is parked");
    }

    @Test(groups = {"car"}, dependsOnMethods = {"startCar", "stopCar"})
    public void parkCar() {
        System.out.println("Car is Parked");
    }

    @Test(dependsOnGroups = {"car"})
    public void carDependentTest() {
        System.out.println("This is a Car Dependent Test");
    }

    @Test(groups = {"bike"})
    public void startBike() {
        System.out.println("Bike is started");
        Assert.fail();
    }

    @Test(groups = {"bike"}, dependsOnMethods = {"startBike"})
    public void driveBike() {
        System.out.println("Bike is being driven");
    }

    @Test(groups = {"bike"}, dependsOnMethods = {"driveBike"})
    public void stopBike() {
        System.out.println("Bike is stopped");
    }

    @Test(groups = {"bike"}, dependsOnMethods = {"startBike", "stopBike"})
    public void parkBike() {
        System.out.println("Bike is Parked");
    }

    @Test(dependsOnGroups = {"bike"}, alwaysRun = true)
    public void bikeDependentTest() {
        System.out.println("This is a Bike Dependent Test, but is allowed to \"Always Run\"");
    }
}
