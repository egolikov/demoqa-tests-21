package guru.qa;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void formTests() {
        //Open URL
        open("/automation-practice-form");

        //Delete Banner, Footer
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //FirstName, LastName, Email
        $("#firstName").setValue("Evgeniy");
        $("#lastName").setValue("Golikov");
        $("#userEmail").setValue("golikov-qa@gmail.com");

        //Gender
        $("#genterWrapper").$(byText("Male")).click();

        //Mobile
        $("#userNumber").setValue("9996669696");

        //DateOfBirth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("November")).click();
        $(".react-datepicker__year-select").$(byText("1993")).click();
        $(".react-datepicker__day--020").click();

        //Subjects
        $("#subjectsInput").setValue("English").pressEnter();

        //Hobbies
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Picture
        $("#uploadPicture").uploadFromClasspath("qa-dev.png");

        //CurrentAddress
        $("#currentAddress").setValue("644003  Address: Omsk city, Lenina str, 3");

        //StateAndCity
        $("#stateCity-wrapper #state").click();
        $("#state").$(byText("NCR")).click();
        $("#stateCity-wrapper #city").click();
        $("#city").$(byText("Noida")).click();

        //SubmitButton
        $("#submit").click();

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

    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}