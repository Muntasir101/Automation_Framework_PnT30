package tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import pages.LoginPage;
import org.testng.annotations.Test;
import utils.PropertyReader;
import java.io.IOException;



public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);


    @Test
    public void LoginTest() throws IOException {
        PropertyReader propertyReader = new PropertyReader("src/main/java/config/baseConfig.properties");
        String baseUrl = propertyReader.getProperty("baseUrl");

        driver.get(baseUrl +"route=account/login"); // navigate Login page
        Reporter.log("Login page Open");
        loginPage = new LoginPage(driver); // initialize login page

        // Test Data
        String email = propertyReader.getProperty("validEmail"); // read email from properties file
        String password = propertyReader.getProperty("validPassword"); // read password from properties file

        // perform login
        loginPage.enterEmailAddress(email);
        Reporter.log("Enter Email: " + email);
        logger.info("Enter Email: " + email);
        //Capture screenshot
        captureScreenshot(email);
        // Add screenshot to Report
        String screenShotPath = "Screenshots/"+email+".png";
        Reporter.log("<a href='" + screenShotPath + "' target ='_blank' >View Email Typed</a>");

        loginPage.enterPassword(password);
        Reporter.log("Enter Password: "+password);
        logger.info("Enter Password: "+password);
        //Capture screenshot
        captureScreenshot(password);
        // Add screenshot to Report
        String screenShotPath2 = "Screenshots/"+password+".png";
        Reporter.log("<a href='" + screenShotPath2 + "' target ='_blank' >View Password Typed</a>");

        loginPage.clickLoginButton();
        Reporter.log("Click Login Button");
        logger.info("Click Login Button");
        captureScreenshot(password);
        // Add screenshot to Report
        String screenShotPath3 = "Screenshots/"+"Login_Status"+".png";
        Reporter.log("<a href='" + screenShotPath2 + "' target ='_blank' >Login_Status</a>");

        Reporter.log("Test Execution Complete");
    }
}
