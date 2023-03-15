import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;

public class PracticeBoxTest {
    @BeforeAll
    static void beforeall() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "Firefox";
        Configuration.browserSize = "1920x1080";
        // Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
    @AfterAll
    static void afterAll(){
        Configuration.holdBrowserOpen = false;
    }
@Test
    void practicefillformtest() {


        /// strings
        String firstName = "Jovan";
        String lastName = "Savovich";
        String userMail = "kgb@jovan.ru";
        String userNumber = "4999886645";
        String currentAddress = "Leprosorium";

        ///open form
        open("/automation-practice-form");
        ///fill form
        $x("//input['#firstName']").setValue(firstName);
        $x("//input[@id='lastName']").setValue(lastName);
        $x("//input[@id='userEmail']").setValue(userMail);
        $x("//label[text()='Other']").click();
        // Далее я попытался сделать все заполнение формы через setbyvalue но последний пункт не получился.
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("2001");
        $(".react-datepicker__month-select").selectOptionByValue("11");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--018").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $x("//label[text()='Reading']").click();
        $x("//input[@id='uploadPicture']").uploadFile(new File("src/test/resources/exmpl.jpg"));
    //$("#uploadPicture").uploadFile(new File("src/test/resources/exmpl.jpg")); как вариант
    $("#currentAddress").setValue(currentAddress);
    $("#react-select-3-input").setValue("Rajasthan").pressEnter();
    $("#react-select-4-input").setValue("Jaipur").pressEnter();
    /// hide overlay banners
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    $(".btn-primary").click();
    /// Ура, а теперь выдача
    $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userMail), text("Other"), text(userNumber),
            text("18 December,2001"), text("Economics"), text("Computer Science"), text("Reading"), text("exmpl.jpg"), text(currentAddress),
            text("Rajasthan Jaipur"));
}

}
