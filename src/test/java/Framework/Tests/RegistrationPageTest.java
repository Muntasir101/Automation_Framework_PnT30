package Framework.Tests;

import Pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationPageTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeMethod
    @Parameters("browserName")
    public void launchBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("Chrome browser is launched");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            System.out.println("Firefox browser is launched");
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            System.out.println("EDGE browser is launched");
        } else {
            System.out.println("Unsupported Browser !!!");
        }
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void RegistrationTest() {
        // Test Data
        String firstName = "John";
        String lastName = "Doe";
        String email = "nomail123@gmail.com";
        String phone = "82728";
        String password = "123456";
        String passwordConfirmation = "123456";


        // perform registration
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterEmailAddress(email);
        registrationPage.enterPhoneNumber(phone);
        registrationPage.enterPassword(password);
        registrationPage.enterPasswordConfirmation(passwordConfirmation);
        registrationPage.subscribeNewsletter();
        registrationPage.privacyPolicy();
        registrationPage.continueButtonClick();
    }

    @AfterMethod
    public void terminateTest() {
        if (driver != null) {
            driver.quit();
            System.out.println("Test Complete");
        } else {
            System.out.println("No Driver found.");
        }


    }
}
