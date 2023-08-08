package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import static guru.qa.utils.TestData.*;

import org.junit.jupiter.api.Test;


public class RegistrationPageTests extends BaseTest {

RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationTest() {

        registrationPage.openPage()
                .removeFixedBanner()
                .removeFooter()
                .setFirstName(firstNameValue)
                .setLastName(lastNameValue)
                .setUserEmail(emailValue)
                .setGender(genderValue)
                .setUserNumber(phoneNumber)
                .setBirthDay("November", "1993", "20")
                .setSubjects("English")
                .setHobbies("Music")
                .uploadPicture("qa-dev.png")
                .setAddress("644003  Address: Omsk city, Lenina str, 3")
                .setState("NCR")
                .setCity("Noida")
                .clickOnSubmitButton();

        registrationPage.checkOverResults("Student Name", firstNameValue + " " + lastNameValue)
                .checkOverResults("Student Email", emailValue)
                .checkOverResults("Gender", genderValue)
                .checkOverResults("Mobile", phoneNumber)
                .checkOverResults("Date of Birth", "20 November,1993")
                .checkOverResults("Subjects", "English")
                .checkOverResults("Hobbies", "Music")
                .checkOverResults("Picture", "qa-dev.png")
                .checkOverResults("Address", "644003 Address: Omsk city, Lenina str, 3")
                .checkOverResults("State and City", "NCR Noida");
    }
}