package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomData {

    static Faker faker = new Faker(new Locale("en-US"));

    private RandomData() {

    }

    public static String firstName() {
        return faker.name().firstName();
    }

    public static String job() {
        return faker.job().title();
    }

}
