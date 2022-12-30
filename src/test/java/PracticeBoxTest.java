import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeBoxTest {
    @BeforeAll
    static void beforeall() {
        Configuration.holdBrowserOpen = true;
        //bConfiguration.browser = "opera";
        Configuration.browserSize = "1920x1080";
        // Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
@Test
    void practicefillformtest() {
        ///open form
        open("/automation-practice-form");
        ///fill form
        $x("//input['#firstName']").setValue("Jovan");
        $x("//input[@id='lastName']").setValue("Savovich");
        $x("//input[@id='userEmail']").setValue("kgb@jovan.ru");
    // не понял как делается следующий пункт, подсмотрел у других, прошу разъяснить:
        $x("//label[text()='Other']").click();
        // Далее я попытался сделать все заполнение формы через setbyvalue но последний пункт не получился.
        $("#userNumber").setValue("4999886645");
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
    $("#currentAddress").setValue("Leprosorium");
    $("#react-select-3-input").setValue("Rajasthan").pressEnter();
    $("#react-select-4-input").setValue("Jaipur").pressEnter();
    /// hide overlay banners
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    $(".btn-primary").click();
    /// Ура, а теперь выдача
    $(".table-responsive").shouldHave(text("Jovan Savovich"), text("kgb@jovan.ru"), text("Other"), text("4999886645"),
            text("18 December,2001"), text("Economics"), text("Computer Science"), text("Reading"), text("exmpl.jpg"), text("Leprosorium"),
            text("Rajasthan Jaipur"));
}

}
