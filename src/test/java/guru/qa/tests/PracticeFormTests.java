package guru.qa.tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends BaseTest {

RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void formTests() {

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


        //Check Results
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Evgeniy Golikov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("golikov-qa@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9996669696"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("20 November,1993"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("qa-dev.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("644003 Address: Omsk city, Lenina str, 3"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
    }
}