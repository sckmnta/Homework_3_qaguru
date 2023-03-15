import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.RegistrationPage;

import java.util.Locale;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker(new Locale("sv"));

    static String firstName,
            lastName,
            userMail,
            userNumber,
            currentAddress;



    @BeforeAll
    static void beforeall() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "Firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @BeforeEach
    void preparetestdata() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userMail = faker.internet().emailAddress();
        userNumber = faker.phoneNumber().subscriberNumber(10);
        currentAddress = faker.address().fullAddress();
    }



    @AfterAll
    static void afterAll() {
        Configuration.holdBrowserOpen = false;
    }

}
