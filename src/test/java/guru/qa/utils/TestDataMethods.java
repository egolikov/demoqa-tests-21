package guru.qa.utils;

import com.github.javafaker.Faker;

import static guru.qa.utils.TestDataProperties.*;

import java.util.concurrent.ThreadLocalRandom;

public class TestDataMethods {

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomFirstName() {
        return fakerEn.name().firstName();
    }

    public static String getRandomLastName() {
        return fakerEn.name().lastName();
    }

    public static String getRandomFullName() {
        return fakerEn.name().fullName();
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

    public static String getRandomMonth() {
        String[] months =  {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return new Faker().options().option(months);
    }

    public static String getRandomYear() {
        return new Faker().random().nextInt(1980, 2001).toString();
    }

    public static String getRandomDay() {
       int day = getRandomInt(1, 28);
            if (day < 10) {
                return "0" + day;
            } else {
                return Integer.toString(day);
            }
        }

    public static String getRandomSubject() {
        String[] subjects =  {"Accounting", "Arts", "Biology", "Chemistry", "Civics", "Economics",
                "English", "Commerce", "Computer Science", "Physics", "Maths", "Hindi", "History", "Social Studies"};
        return new Faker().options().option(subjects);
    }

    public static String getRandomHobie() {
        String[] hobbies =  {"Sports", "Reading", "Music"};
        return new Faker().options().option(hobbies);
    }

    public static String getRandomAddress() {
        return fakerEn.address().fullAddress();
    }

    public static String getRandomState() {
        String[] states =  {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return new Faker().options().option(states);
    }

    public static String getRandomCity(String stateValue) {
        switch (stateValue) {
            case "NCR": {
                String[] city =  {"Delhi", "Gurgaon", "Noida"};
                return new Faker().options().option(city);
            }
            case "Uttar Pradesh": {
                String[] city =  {"Agra", "Lucknow", "Merrut"};
                return new Faker().options().option(city);
            }
            case "Haryana": {
                String[] city =  {"Karnal", "Panipat"};
                return new Faker().options().option(city);
            }
            case "Rajasthan": {
                String[] city =  {"Jaipur", "Jaiselmer"};
                return new Faker().options().option(city);
            }
        }
        return null;
    }

}
