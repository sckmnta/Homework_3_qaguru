import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920*1080";
    }

    @Test
    void demoqaTest() {
        open("https://demoqa.com/text-box");
        $(".main-header").shouldHave(text("Text BoX"));
        $("#userName").setValue("Jovan");
        $("#userEmail").setValue("jovan@jovan.ru");
        $("#currentAddress").setValue("Srpska");
        $("#permanentAddress").setValue("Rsska");
        $("#submit").click();
        $("#output").shouldBe(visible);

    }
}
