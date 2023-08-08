package guru.qa.tests;

import guru.qa.pages.TextBoxPage;
import static guru.qa.utils.TestData.*;

import org.junit.jupiter.api.Test;

public class TextBoxPageTest extends BaseTest {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void textBoxTest() {
        textBoxPage.openPage()
                .setFullName(fullNameValue)
                .setEmail(emailValue)
                .setCurrentAddress(addressValue)
                .setPermanentAddress(addressValue)
                .clickOnSubmitButton();

        textBoxPage.checkOverResultName(fullNameValue)
                .checkOverResultEmail(emailValue)
                .checkOverResultCurrentAddress(addressValue)
                .checkOverResultPermanentAddress(addressValue);
    }
}