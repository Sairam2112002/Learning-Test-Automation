package learning.apitesting.restassured.pojo;

import com.github.javafaker.Faker;

public record Person(
        String firstName,
        String lastName,
        String email,
        String employmentRole,
        int age,
         String phoneNumber) {

    public static Person getPerson() {
        Faker faker = new Faker();
        return new Person(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.job().title(),
                faker.number().numberBetween(18, 60),
                faker.phoneNumber().phoneNumber()
        );
    }
}

