package guru.qa.tests;

import guru.qa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxPageTest extends BaseTest {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void textBoxTest() {
        textBoxPage.openPage()
                .setFullName("Golikov Evgeniy")
                .setEmail("golikov-qa@gmail.com")
                .setCurrentAddress("644003  Address: Omsk city, Lenina str, 3")
                .setPermanentAddress("644003  Address: Omsk city, Lenina str, 3")
                .clickOnSubmitButton();

        textBoxPage.checkOverResultName("Golikov Evgeniy")
                .checkOverResultEmail("golikov-qa@gmail.com")
                .checkOverResultCurrentAddress("644003  Address: Omsk city, Lenina str, 3")
                .checkOverResultPermanentAddress("644003  Address: Omsk city, Lenina str, 3");
    }
}