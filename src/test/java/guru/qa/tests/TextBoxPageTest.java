package guru.qa.tests;

import guru.qa.pages.TextBoxPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static guru.qa.utils.TestDataProperties.*;

public class TextBoxPageTest extends BaseTest {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @Tag("demoQA")
    @DisplayName("Успешная регистрация TextBox")
    void textBoxTest() {

        step("Открыть форму", () -> {
        textBoxPage.openPage();
        });

        step("Заполнить поля", () -> {
        textBoxPage.setFullName(fullNameValue)
                            .setEmail(emailValue)
                            .setCurrentAddress(addressValue)
                            .setPermanentAddress(addressValue)
                            .clickOnSubmitButton();
        });


        step("Проверить результат заполнения формы", () -> {
        textBoxPage.checkOverResultName(fullNameValue)
                .checkOverResultEmail(emailValue)
                .checkOverResultCurrentAddress(addressValue)
                .checkOverResultPermanentAddress(addressValue);
        });
    }
}