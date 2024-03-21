package Framework.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PropertyReader;

import java.io.File;
import java.io.IOException;


public class LoginPageTest {
    private static WebDriver driver;
    private LoginPage loginPage;


    @BeforeMethod
    @Parameters("browserName")
    public void launchBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            Reporter.log("Chrome browser is launched");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            Reporter.log("Firefox browser is launched");
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            Reporter.log("EDGE browser is launched");
        } else {
            Reporter.log("Unsupported Browser !!!");
        }
    }
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
        //Capture screenshot
        captureScreenshot(email);
        // Add screenshot to Report
        String screenShotPath = "Screenshots/"+email+".png";
        Reporter.log("<a href='" + screenShotPath + "' target ='_blank' >View Email Typed</a>");

        loginPage.enterPassword(password);
        Reporter.log("Enter Password: "+password);
        //Capture screenshot
        captureScreenshot(password);
        // Add screenshot to Report
        String screenShotPath2 = "Screenshots/"+password+".png";
        Reporter.log("<a href='" + screenShotPath2 + "' target ='_blank' >View Password Typed</a>");

        loginPage.clickLoginButton();
        Reporter.log("Click Login Button");
        captureScreenshot(password);
        // Add screenshot to Report
        String screenShotPath3 = "Screenshots/"+"Login_Status"+".png";
        Reporter.log("<a href='" + screenShotPath2 + "' target ='_blank' >Login_Status</a>");

        Reporter.log("Test Execution Complete");
    }

    @AfterMethod
    public void terminateTest() {
        if (driver != null) {
            driver.quit();
            Reporter.log("Tear Down");
        } else {
            Reporter.log("No Driver found.");
        }
    }

    public static void captureScreenshot(String screenShotName) throws IOException, IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("test-output/Screenshots/"+screenShotName+".png"),true);
    }
    public static void captureFullPageScreenshot(String screenShotName) throws IOException {
        File src = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("test-output/Screenshots/"+screenShotName+".png"));
    }
}
