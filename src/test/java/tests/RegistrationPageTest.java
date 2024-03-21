package tests;


import org.testng.Reporter;
import pages.RegistrationPage;
import org.testng.annotations.Test;
import utils.Common;
import java.io.IOException;

public class RegistrationPageTest extends BaseTest {
    private RegistrationPage registrationPage;

    @Test
    public void RegistrationTest() throws IOException {
        String newEmail = Common.randomEmail();
        // Test Data
        String firstName = "John";
        String lastName = "Doe";
        String email = newEmail;
        String phone = "82728";
        String password = "123456";
        String passwordConfirmation = "123456";

        // perform registration
        registrationPage.enterFirstName(firstName);
        Reporter.log("Enter First Name: " + firstName);
        //Capture screenshot
        captureScreenshot(firstName);
        // Add screenshot to Report
        String screenShotPath = "Screenshots/"+firstName+".png";
        Reporter.log("<a href='" + screenShotPath + "' target ='_blank' >View First name Typed</a>");

        registrationPage.enterLastName(lastName);
        Reporter.log("Enter Last Name: " + lastName);
        //Capture screenshot
        captureScreenshot(lastName);
        // Add screenshot to Report
        String screenShotPath2 = "Screenshots/"+lastName+".png";
        Reporter.log("<a href='" + screenShotPath2 + "' target ='_blank' >View Last name Typed</a>");

        registrationPage.enterEmailAddress(email);
        Reporter.log("Enter Email: " + email);
        //Capture screenshot
        captureScreenshot(email);
        // Add screenshot to Report
        String screenShotPath3 = "Screenshots/"+email+".png";
        Reporter.log("<a href='" + screenShotPath3 + "' target ='_blank' >View Email Typed</a>");
        Common.writeFile("src/test/java/data/valid_users.txt",newEmail);

        registrationPage.enterPhoneNumber(phone);
        Reporter.log("Enter Phone: " + phone);
        //Capture screenshot
        captureScreenshot(phone);
        // Add screenshot to Report
        String screenShotPath4 = "Screenshots/"+phone+".png";
        Reporter.log("<a href='" + screenShotPath4 + "' target ='_blank' >View Phone Typed</a>");

        registrationPage.enterPassword(password);
        Reporter.log("Enter Password: " + password);
        //Capture screenshot
        captureScreenshot(password);
        // Add screenshot to Report
        String screenShotPath5 = "Screenshots/"+password+".png";
        Reporter.log("<a href='" + screenShotPath5 + "' target ='_blank' >View Password Typed</a>");

        registrationPage.enterPasswordConfirmation(passwordConfirmation);
        Reporter.log("Enter Confirm Password: " + passwordConfirmation);
        //Capture screenshot
        captureScreenshot(passwordConfirmation);
        // Add screenshot to Report
        String screenShotPath6= "Screenshots/"+passwordConfirmation+".png";
        Reporter.log("<a href='" + screenShotPath6 + "' target ='_blank' >View Confirm Password Typed</a>");

        registrationPage.subscribeNewsletter();
        registrationPage.privacyPolicy();
        registrationPage.continueButtonClick();
        Reporter.log("Click on continue Button");
        //Capture screenshot
        captureScreenshot("Continue");
        // Add screenshot to Report
        String screenShotPath7= "Screenshots/"+"Continue"+".png";
        Reporter.log("<a href='" + screenShotPath7 + "' target ='_blank' >View Registration Status</a>");
    }

}