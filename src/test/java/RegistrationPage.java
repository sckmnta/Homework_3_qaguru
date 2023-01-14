package pages;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstName(String value) {
        $x("//input['#firstName']").setValue(value);

    }

}
