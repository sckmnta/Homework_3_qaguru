package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement
    firstNameInput = $x("//input[@id='lastName']");

    private final
    String firstName = "Jovan",
            lastName = "Savovich",
            userMail = "kgb@jovan.ru",
            userNumber = "4999886645",
            currentAddress = "Leprosorium";
    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstName(String value) {
        firstNameInput.setValue(firstName);

    }

}
