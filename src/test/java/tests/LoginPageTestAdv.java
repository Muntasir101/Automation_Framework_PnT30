package tests;


import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.PropertyReader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import static io.qameta.allure.SeverityLevel.CRITICAL;


public class LoginPageTestAdv extends BaseTest {
    private LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(LoginPageTestAdv.class);


    @Test
    @Description("This test attempts to log into the website using a email and a password.")
    @Severity(CRITICAL)
    @Owner("Muntasir Abdullah")
    @Link(name = "Website", url = "https://tutorialsninja.com/demo/")
    public void LoginTest() throws IOException {
        PropertyReader propertyReader = new PropertyReader("src/main/java/config/baseConfig.properties");
        String baseUrl = propertyReader.getProperty("baseUrl");

        driver.get(baseUrl +"route=account/login"); // navigate Login page
        Reporter.log("Login page Open");
        loginPage = new LoginPage(driver); // initialize login page

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        step1_enter_Email();
        step2_enter_Password();
        step3_click_Login();

    }
    @Step("Step 1")
    public void step1_enter_Email() throws IOException {
        PropertyReader propertyReader = new PropertyReader("src/main/java/config/baseConfig.properties");
        String email = propertyReader.getProperty("validEmail"); // read email from properties file
        // perform login
        loginPage.enterEmailAddress(email);
        Reporter.log("Enter Email: " + email);
        logger.info("Enter Email: " + email);
        //Capture screenshot
        captureScreenshot(email);
        // Add screenshot to Report
        String screenShotPath = "Screenshots/"+email+".png";
        Reporter.log("<a href='" + screenShotPath + "' target ='_blank' >View Email Typed</a>");

        // add screenshot in Allure
        try (InputStream is = Files.newInputStream(Paths.get("test-output\\"+screenShotPath))) {
            Allure.attachment("Email.png", is);
        }

    }
    @Step("Step 2")
    public void step2_enter_Password() throws IOException {
        PropertyReader propertyReader = new PropertyReader("src/main/java/config/baseConfig.properties");
        String password = propertyReader.getProperty("validPassword"); // read password from properties file
        loginPage.enterPassword(password);
        Reporter.log("Enter Password: "+password);
        logger.info("Enter Password: "+password);
        //Capture screenshot
        captureScreenshot(password);
        // Add screenshot to Report
        String screenShotPath2 = "Screenshots/"+password+".png";
        Reporter.log("<a href='" + screenShotPath2 + "' target ='_blank' >View Password Typed</a>");

        // add screenshot in Allure
        try (InputStream is = Files.newInputStream(Paths.get("test-output\\"+screenShotPath2))) {
            Allure.attachment("Password.png", is);
        }
    }
    @Step("Step 3")
    public void step3_click_Login() throws IOException {
        loginPage.clickLoginButton();
        Reporter.log("Click Login Button");
        logger.info("Click Login Button");
        captureScreenshot("LoginStatus");
        // Add screenshot to Report
        String screenShotPath3 = "Screenshots/"+"Login_Status"+".png";
        Reporter.log("<a href='" + screenShotPath3 + "' target ='_blank' >Login_Status</a>");

        Reporter.log("Test Execution Complete");

        // add screenshot in Allure
        try (InputStream is = Files.newInputStream(Paths.get("test-output\\Screenshots\\LoginStatus.png"))) {
            Allure.attachment("Login_Status.png", is);
        }
    }
}
