package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static guru.qa.utils.TestDataProperties.*;


public class RegistrationPageTests extends BaseTest {

RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("demoQA")
    @Tag("registrationTest")
    @DisplayName("Успешная регистрация RegistrationPage")
    void registrationTest() {

        step("Открыть форму", () -> {
        registrationPage.openPage()
                .removeFixedBanner()
                .removeFooter();
        });

        step("Заполнить поля", () -> {
        registrationPage.setFirstName(firstNameValue)
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
        });

        step("Проверить результат заполнения формы", () -> {
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
        });
    }
}