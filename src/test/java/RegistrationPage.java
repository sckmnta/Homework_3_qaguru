package pages;
import com.codeborne.selenide.SelenideElement;
import pages.Components.CalendarComponent;
import pages.components.RegistrationModal;
import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationModal registrationModal = new RegistrationModal();
    private SelenideElement
            firstNameInput = $x("//input[@id='firstName']"),
            lastNameInput = $x("//input[@id='lastName']"),
            mailInput = $x("//input[@id='userEmail']"),
            numberInput = $("#userNumber"),
            adressInput = $("#currentAddress"),
            genderInput = $x("//label[text()='Other']"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput =  $("#hobbiesWrapper"), //$x("//label[text()='Reading']"), не работает почему то):
            uploadPicture =   $x("//input[@id='uploadPicture']"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitClick = $(".btn-primary");


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

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyModal() {
        registrationModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationModal.verifyResult(key, value);
        return this;
    }

    public RegistrationPage setSecondSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobby(String value) {
        hobbiesInput.$(byText(value)).click(); //setValue(value).click(); не работает почему то):
        return this;
    }
    public RegistrationPage setPicture() {
        uploadPicture.uploadFile(new File("src/test/resources/exmpl.jpg"));
        return this;
    }
    public RegistrationPage setState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage clickSubmit() {
        submitClick.click();
        return this;
    }



}

