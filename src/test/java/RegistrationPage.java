package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement
    firstNameInput = $x("//input[@id='firstName']"),
    lastNameInput = $x("//input[@id='lastName']"),
    mailInput = $x("//input[@id='userEmail']"),
    numberInput = $("#userNumber"),
    adressInput = $("#currentAddress"),
    genderInput =  $x("//label[text()='Other']");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setMail(String value) {
        mailInput.setValue(value);
        return this;
    }
    public RegistrationPage setPhone(String value) {
        numberInput.setValue(value);
        return this;
        }
    public RegistrationPage setAdress(String value) {
        adressInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender() {
        genderInput.click();
        return this;
    }

}

