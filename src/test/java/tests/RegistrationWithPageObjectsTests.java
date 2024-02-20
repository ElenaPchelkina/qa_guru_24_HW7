package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage().closeBanners()
                .setFirstName("Irina")
                .setLastName("Ivanova")
                .setEmail("irina@ivanova.com")
                .setGender("Female")
                .setUserNumber("9001112233")
                .setDateOfBirth("30", "July", "2008")
                .setSubject("history")
                .setHobbies("Reading")
                .setPicture("123.jpg")
                .setAddress("Moscow, Leninsky Prospekt, 56-67")
                .setState("Haryana")
                .setCity("Karnal")
                .submit();

        registrationPage.checkResult("Student Name", "Irina Ivanova")
                .checkResult("Student Email", "irina@ivanova.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9001112233")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "history")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "123.jpg")
                .checkResult("Address", "Moscow, Leninsky Prospekt, 56-67")
                .checkResult("State and City", "Haryana Karnal");

    }

    @Test
    void registrationMinTest() {
        registrationPage.openPage().closeBanners()
                .setFirstName("Irina")
                .setLastName("Ivanova")
                .setGender("Female")
                .setUserNumber("9001112233")
                .submit();

        registrationPage.checkResult("Student Name", "Irina Ivanova")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9001112233");

    }

    @Test
    void registrationNegativeTest() {
        registrationPage.openPage().closeBanners()
                .setFirstName("Irina")
                .setGender("Female")
                .setUserNumber("9001112233")
                .submit();

        registrationPage.checkModalDialog();

    }
}
