package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import static guru.qa.utils.TestDataProperties.*;

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
                .setBirthDay(monthValue, yearValue, dayValue)
                .setSubjects(subjectValue)
                .setHobbies(hobieValue)
                .uploadPicture(fileNameValue)
                .setAddress(addressValue)
                .setState(stateValue)
                .setCity(cityValue)
                .clickOnSubmitButton();

        registrationPage.checkOverResults("Student Name", firstNameValue + " " + lastNameValue)
                .checkOverResults("Student Email", emailValue)
                .checkOverResults("Gender", genderValue)
                .checkOverResults("Mobile", phoneNumber)
                .checkOverResults("Date of Birth", dayValue + " " + monthValue + "," + yearValue)
                .checkOverResults("Subjects", subjectValue)
                .checkOverResults("Hobbies", hobieValue)
                .checkOverResults("Picture", fileNameValue)
                .checkOverResults("Address", addressValue)
                .checkOverResults("State and City", stateValue + " " + cityValue);
    }
}