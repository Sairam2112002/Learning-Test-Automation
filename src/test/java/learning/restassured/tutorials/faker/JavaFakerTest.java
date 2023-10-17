package learning.restassured.tutorials.faker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerTest {
    @Test
    public void generateDummyData() {
        Faker faker = new Faker();

        System.out.println("First Name: " + faker.name().firstName());
        System.out.println("Last Name: " + faker.name().lastName());
        System.out.println("Blood Group: " + faker.name().bloodGroup());
        System.out.println("Aircraft Name: " + faker.aviation().aircraft());
        System.out.println("Airport Name: " + faker.aviation().airport());
    }
}
