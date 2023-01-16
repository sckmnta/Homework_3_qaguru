import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeBoxWithObjectsTest extends TestBase {

@Test
    void practicefillformtest() {
        /// strings
        String firstName = "Jovan";
        String lastName = "Savovich";
        String userMail = "kgb@jovan.ru";
        String userNumber = "4999886645";
        String currentAddress = "Leprosorium";
        ///open form
    registrationPage.openPage()
    ///fill form
                            .setFirstName(firstName)
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setMail(userMail)
                            .setGender()
                            .setPhone(userNumber)
                            .setBirthDate("18", "December", "2001")
                            .setSecondSubject("Economics")
                            .setHobby("Reading")
                            .setPicture()
                            .setAdress(currentAddress)
                            .setState("Rajasthan")
                            .setCity("Jaipur")
                            .clickSubmit();
    registrationPage.setAdress(currentAddress);
    /// hide overlay banners
    $(".btn-primary").click();
    /// Ура, а теперь выдача
    registrationPage.verifyModal()
            .verifyResult("Student Name",  firstName + " Savovich")
            .verifyResult("Student Email", userMail)
            .verifyResult("Gender", "Other")
            .verifyResult("Mobile", userNumber)
            .verifyResult("Date of Birth", "18 December,2001")
            .verifyResult("Subjects", "Economics")
            .verifyResult("Hobbies", "Reading")
            .verifyResult("Picture", "exmpl.jpg")
            .verifyResult("Address", currentAddress)
            .verifyResult("State and City", "Rajasthan Jaipur");
}

}
