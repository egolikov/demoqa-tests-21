package guru.qa.utils;

import com.github.javafaker.Faker;

import static guru.qa.utils.TestDataMethods.*;

import java.util.Locale;

public class TestDataProperties {

    static Faker fakerEn = new Faker(new Locale("en"));

    public static String firstNameValue = getRandomFirstName(),
            lastNameValue = getRandomLastName(),
            fullNameValue = getRandomFullName(),
            emailValue = getRandomEmail(),
            genderValue = getRandomGender(),
            phoneNumber = getRandomPhoneNumber(),
            monthValue = getRandomMonth(),
            yearValue = getRandomYear(),
            dayValue = getRandomDay(),
            subjectValue = getRandomSubject(),
            hobieValue = getRandomHobie(),
            fileNameValue = "qa-dev.png",
            addressValue = getRandomAddress(),
            stateValue = getRandomState(),
            cityValue = getRandomCity(stateValue);
}
