package tests;


import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Excel_utils;
import utils.PropertyReader;

import java.io.IOException;

import static io.qameta.allure.SeverityLevel.CRITICAL;


public class LoginPageTest_DD extends BaseTest {
    private LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(LoginPageTest_DD.class);


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

        //Excel Implementation
        Excel_utils excelUtils = new Excel_utils("src\\test\\java\\data\\Login_data.xlsx");
        String sheetName = "Sheet1";

        int rowCount = excelUtils.getRowCount(sheetName);

        for(int rowNum=2;rowNum<=rowCount;rowNum++){
            // Test Data
            String dd_email = excelUtils.getCellData(sheetName,"Email",rowNum);
            String dd_password = excelUtils.getCellData(sheetName,"Password",rowNum);

            // perform login
            loginPage.enterEmailAddress(dd_email);
            Reporter.log("Enter Email: " + dd_email);
            logger.info("Enter Email: " + dd_email);
            //Capture screenshot
            captureScreenshot(dd_email);
            // Add screenshot to Report
            String screenShotPath = "Screenshots/"+dd_email+".png";
            Reporter.log("<a href='" + screenShotPath + "' target ='_blank' >View Email Typed</a>");

            loginPage.enterPassword(dd_password);
            Reporter.log("Enter Password: "+dd_password);
            logger.info("Enter Password: "+dd_password);
            //Capture screenshot
            captureScreenshot(dd_password);
            // Add screenshot to Report
            String screenShotPath2 = "Screenshots/"+dd_password+".png";
            Reporter.log("<a href='" + screenShotPath2 + "' target ='_blank' >View Password Typed</a>");

            loginPage.clickLoginButton();
            Reporter.log("Click Login Button");
            logger.info("Click Login Button");
            captureScreenshot("LoginStatus");
            // Add screenshot to Report
            String screenShotPath3 = "Screenshots/"+"Login_Status"+".png";
            Reporter.log("<a href='" + screenShotPath3 + "' target ='_blank' >Login_Status</a>");

            // Login Pass fail verification
            String Expected_title = "Account Login";
            String Actual_title = driver.getTitle();
            if (Expected_title.equals(Actual_title)){
                // write to excel
                excelUtils.setCellData(sheetName,"Actual Result",rowNum,"Login Error");
            }
            else {
                // write to excel
                excelUtils.setCellData(sheetName,"Actual Result",rowNum,"Login Success");
            }

            Reporter.log("Test Execution Complete");

        }
    }
}
