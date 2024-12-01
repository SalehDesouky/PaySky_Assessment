package org.tests.Utils;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.concurrent.ThreadLocalRandom;

public class TestData {

    @DataProvider(name = "registrationData")
    public static Object[][] getRegistrationData() {
        Faker faker = new Faker();

        // Generate random test data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = "P@ssw0rd"+faker.internet().password(5, 16);
        String dob = generateDOB();
        String address = faker.address().streetAddress();
        String postcode = faker.address().zipCode();
        String city = faker.address().city();
        String state = faker.address().state();
        String country = "EG"; // Select by value (e.g., Egypt)
        String phone = faker.number().digits(10);


        // Return data as a two-dimensional object array
        return new Object[][] {
                { firstName, lastName, email, password, dob, address, postcode, city, state, country, phone}
        };
    }
    private static String generateDOB() {
        // Generate a random year between 1990 and 2000
        int year = ThreadLocalRandom.current().nextInt(1990, 2005);
        // Generate a random month between 1 and 12
        int month = ThreadLocalRandom.current().nextInt(1, 13);
        // Generate a random day between 1 and the last day of the generated month
        int day = ThreadLocalRandom.current().nextInt(1, 29); // Safe range for all months (we can fine-tune for specific months if needed)

        // Format the DOB in Y-m-d
        String formattedDOB = String.format("%02d/%02d/%04d", day, month, year);
        System.out.println("Generated DOB: " + formattedDOB);

        return formattedDOB;
    }
}
