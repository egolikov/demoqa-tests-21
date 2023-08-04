package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationPageTests extends BaseTest {

RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationTest() {

        registrationPage.openPage()
                .setFirstName("Evgeniy")
                .setLastName("Golikov")
                .setUserEmail("golikov-qa@gmail.com")
                .setGender("Male")
                .setUserNumber("9996669696")
                .setBirthDay("November", "1993", "20")
                .setSubjects("English")
                .setHobbies("Music")
                .uploadPicture("qa-dev.png")
                .setAddress("644003  Address: Omsk city, Lenina str, 3")
                .setState("NCR")
                .setCity("Noida")
                .clickOnSubmitButton();

        registrationPage.checkOverResults("Student Name", "Evgeniy Golikov")
                .checkOverResults("Student Email", "golikov-qa@gmail.com")
                .checkOverResults("Gender", "Male")
                .checkOverResults("Mobile", "9996669696")
                .checkOverResults("Date of Birth", "20 November,1993")
                .checkOverResults("Subjects", "English")
                .checkOverResults("Hobbies", "Music")
                .checkOverResults("Picture", "qa-dev.png")
                .checkOverResults("Address", "644003 Address: Omsk city, Lenina str, 3")
                .checkOverResults("State and City", "NCR Noida");
    }
}