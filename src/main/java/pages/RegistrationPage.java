package pages;

import base.BasePage;
import locators.RegistrationPageLocators;
import org.openqa.selenium.WebDriver;
public class RegistrationPage extends BasePage {


    // Create a constructor
    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    public void enterFirstName(String firstName){
        driver.findElement(RegistrationPageLocators.FIRST_NAME_INPUT).clear();
        driver.findElement(RegistrationPageLocators.FIRST_NAME_INPUT).sendKeys(firstName);

    }
    public void enterLastName(String lastName){
        driver.findElement(RegistrationPageLocators.LAST_NAME_INPUT).clear();
        driver.findElement(RegistrationPageLocators.LAST_NAME_INPUT).sendKeys(lastName);
    }
    public void enterEmailAddress(String email){
        driver.findElement(RegistrationPageLocators.EMAIL_INPUT).clear();
        driver.findElement(RegistrationPageLocators.EMAIL_INPUT).sendKeys(email);
    }

    public void enterPhoneNumber(String phoneNumber){
        driver.findElement(RegistrationPageLocators.PHONE_INPUT).clear();
        driver.findElement(RegistrationPageLocators.PHONE_INPUT).sendKeys(phoneNumber);
    }
    public void enterPassword(String password){
        driver.findElement(RegistrationPageLocators.PASSWORD_INPUT).clear();
        driver.findElement(RegistrationPageLocators.PASSWORD_INPUT).sendKeys(password);
    }
    public void enterPasswordConfirmation(String passwordConfirmation){
        driver.findElement(RegistrationPageLocators.PASSWORD_CONFIRM_INPUT).clear();
        driver.findElement(RegistrationPageLocators.PASSWORD_CONFIRM_INPUT).sendKeys(passwordConfirmation);
    }

    public void subscribeNewsletter(){
        driver.findElement(RegistrationPageLocators.SUBSCRIBE_BUTTON).click();
    }

    public void privacyPolicy(){
        driver.findElement(RegistrationPageLocators.PRIVACY_POLICY_BUTTON).click();
    }

    public void continueButtonClick(){
        driver.findElement(RegistrationPageLocators.CONTINUE_BUTTON).click();
    }

}