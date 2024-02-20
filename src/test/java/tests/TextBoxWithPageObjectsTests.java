package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxWithPageObjectsTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPageTextBox().closeBanners()
                    .setUserName("Alex")
                    .setUserEmail("alex@egorov.com")
                    .setCurrentAddress("Some street 1")
                    .setPermanentAddress("Another street 1")
                    .submit();

        textBoxPage.outputInfoCheck("name", "Alex")
                .outputInfoCheck("email", "alex@egorov.com")
                .outputInfoCheck("currentAddress", "Some street 1")
                .outputInfoCheck("permanentAddress", "Another street 1");
    }
}
