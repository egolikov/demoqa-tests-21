package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

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

        /** Main info? */
        $("#firstName").setValue("Evgeniy");
        $("#lastName").setValue("Golikov");
        $("#userEmail").setValue("golikov-qa@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9996669696");

        //Календарь todo
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").$(byText("November")).click();
//        $(".react-datepicker__year-select").$(byText("1993")).click();
//        $(".react-datepicker__week").$(withText("20")).click(); this todo

        //subjects todo
//        $("#subjectsWrapper").click();
//        $("#subjectsWrapper").setValue("English").pressEnter(); todo this?

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/qa-dev.png"));

        $("#currentAddress").setValue("644003  Address: Omsk city, Lenina str, 3");


        /** State and City */
        $("#stateCity-wrapper #state").click();
        $("#state").$(byText("NCR")).click();
        $("#stateCity-wrapper #city").click();
        $("#city").$(byText("Noida")).click();


        /** Submit button */
        $("#submit").click();







    }
}
