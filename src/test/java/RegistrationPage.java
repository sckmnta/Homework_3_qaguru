package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement
    firstNameInput = $x("//input[@id='firstName']"),
    lastNameInput = $x("//input[@id='lastName']"),
    mailInput = $x("//input[@id='userEmail']"),
    numberInput = $("#userNumber");


    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }
    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }
    public void setMail(String value) {
        mailInput.setValue(value);
    }
    public void setPhone(String value) {
        numberInput.setValue(value);
        }

}

