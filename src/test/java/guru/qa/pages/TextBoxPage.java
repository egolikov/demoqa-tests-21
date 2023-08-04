package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    SelenideElement
            fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            overResultName = $("#output #name"),
            overResultEmail = $("#output #email"),
            overResultCurrentAddress = $("#output #currentAddress"),
            overResultPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public  TextBoxPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public TextBoxPage checkOverResultName(String value) {
        overResultName.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkOverResultEmail(String value) {
        overResultEmail.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkOverResultCurrentAddress(String value) {
        overResultCurrentAddress.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkOverResultPermanentAddress(String value) {
        overResultPermanentAddress.shouldHave(text(value));

        return this;
    }
}
