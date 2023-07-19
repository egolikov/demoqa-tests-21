package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void formTests() {
        open("/automation-practice-form");
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
        $("#subjectsContainer").click();
        $("#subjectsContainer").setValue("E").pressEnter();

        //Hobbies
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Picture
        $("#uploadPicture").uploadFile(new File("src/test/resources/qa-dev.png"));

        //CurrentAddress
        $("#currentAddress").setValue("644003  Address: Omsk city, Lenina str, 3");

        //StateAndCity
        $("#stateCity-wrapper #state").click();
        $("#state").$(byText("NCR")).click();
        $("#stateCity-wrapper #city").click();
        $("#city").$(byText("Noida")).click();

        //SubmitButton
        $("#submit").click();

    }
}
