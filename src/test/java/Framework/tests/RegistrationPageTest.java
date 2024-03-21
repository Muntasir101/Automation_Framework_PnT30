package Framework.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Common;

import java.io.File;
import java.io.IOException;

public class RegistrationPageTest {
    private static WebDriver driver;
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
        Common.writeFile("src/test/java/Framework/data/valid_users.txt",newEmail);

        registrationPage.enterPhoneNumber(phone);
        Reporter.log("Enter Email: " + phone);
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
        Reporter.log("Enter Email: " + passwordConfirmation);
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

    @AfterMethod
    public void terminateTest() {
        if (driver != null) {
            driver.quit();
            System.out.println("Test Complete");
        } else {
            System.out.println("No Driver found.");
        }
    }
    public static void captureScreenshot(String screenShotName) throws IOException, IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("test-output/Screenshots/"+screenShotName+".png"),true);
    }
}