import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeall() {
        Configuration.holdBrowserOpen = true;
        //Configuration.browser = "opera";
        Configuration.browserSize = "1920x1080";
        // Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
    @AfterAll
    static void afterAll(){
        Configuration.holdBrowserOpen = false;
    }

}
