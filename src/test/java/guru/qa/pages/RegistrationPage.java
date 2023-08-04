package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName").setValue("Evgeniy"),
            lastNameInput = $("#lastName").setValue("Golikov"),
            userEmailInput = $("#userEmail").setValue("golikov-qa@gmail.com"),
            genderInput = $("#genterWrapper"),
            userNumber = $("#userNumber");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.$(byText(value));

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public  RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public  RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }


}
