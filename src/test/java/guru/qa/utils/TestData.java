package guru.qa.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    static Faker fakerEn = new Faker(new Locale("en"));

    public static String firstNameValue = getRandomFirstName(),
            lastNameValue = getRandomLastName(),
            emailValue = getRandomEmail(),
            genderValue = getRandomGender(),
            phoneNumber = getRandomPhoneNumber();

    public static String getRandomFirstName() {
        return fakerEn.name().firstName();
    }

    public static String getRandomLastName() {
        return fakerEn.name().lastName();
    }

    public static String getRandomEmail() {
        return fakerEn.internet().emailAddress();
    }

    public static String getRandomGender() {
        String[] genders =  {"Male", "Female", "Other"};
        return new Faker().options().option(genders);
    }

    public static String getRandomPhoneNumber() {
        return fakerEn.numerify("##########");
    }

}
