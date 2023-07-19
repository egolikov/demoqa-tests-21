package guru.qa;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

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

        //Check Results
        $x("//td[contains(text(), 'Student Name')]/following-sibling::td[1]").shouldHave(text("Evgeniy Golikov"));
        $x("//td[contains(text(), 'Student Email')]/following-sibling::td[1]").shouldHave(text("golikov-qa@gmail.com"));
        $x("//td[contains(text(), 'Gender')]/following-sibling::td[1]").shouldHave(text("Male"));
        $x("//td[contains(text(), 'Mobile')]/following-sibling::td[1]").shouldHave(text("9996669696"));
        $x("//td[contains(text(), 'Date of Birth')]/following-sibling::td[1]").shouldHave(text("20 November,1993"));
        $x("//td[contains(text(), 'Subjects')]/following-sibling::td[1]").shouldHave(text("English"));
        $x("//td[contains(text(), 'Hobbies')]/following-sibling::td[1]").shouldHave(text("Music"));
        $x("//td[contains(text(), 'Picture')]/following-sibling::td[1]").shouldHave(text("qa-dev.png"));
        $x("//td[contains(text(), 'Address')]/following-sibling::td[1]").shouldHave(text("644003 Address: Omsk city, Lenina str, 3"));
        $x("//td[contains(text(), 'State and City')]/following-sibling::td[1]").shouldHave(text("NCR Noida"));
    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}