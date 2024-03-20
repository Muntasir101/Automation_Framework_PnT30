package pages;

import base.BasePage;
import locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    // Create a constructor
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterEmailAddress(String email){
        driver.findElement(LoginPageLocators.EMAIL_INPUT).clear();
        driver.findElement(LoginPageLocators.EMAIL_INPUT).sendKeys(email);
    }
    public void enterPassword(String password){
        driver.findElement(LoginPageLocators.PASSWORD_INPUT).clear();
        driver.findElement(LoginPageLocators.PASSWORD_INPUT).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(LoginPageLocators.LOGIN_BUTTON).click();
    }
}
