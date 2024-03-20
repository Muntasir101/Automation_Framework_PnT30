package Framework.Tests;

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

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

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
    }
    @Test
    public void LoginTest(){
        PropertyReader propertyReader = new PropertyReader("src/main/java/config/baseConfig.properties");
        String baseUrl = propertyReader.getProperty("baseUrl");

        driver.get(baseUrl +"route=account/login"); // navigate Login page
        loginPage = new LoginPage(driver); // initialize login page

        // Test Data
        String email = propertyReader.getProperty("validEmail"); // read email from properties file
        String password = propertyReader.getProperty("validPassword"); // read password from properties file

        // perform login
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
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
