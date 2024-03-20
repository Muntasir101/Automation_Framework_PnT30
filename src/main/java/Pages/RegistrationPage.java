package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
public class RegistrationPage {

    private final WebDriver driver;
    private WebElement FirstName;
    private WebElement LastName;
    private WebElement EmailAddress;

    private WebElement PhoneNumber;
    private WebElement Password;
    private WebElement PasswordConfirmation;
    private WebElement SubscribeNewsletter;
    private WebElement PrivacyPolicy;
    private WebElement ContinueButton;

    // Create a constructor
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        initializeElement();
    }

    private void initializeElement() {
        FirstName = driver.findElement(By.cssSelector("#input-firstname"));
        LastName = driver.findElement(By.cssSelector("#input-lastname"));
        EmailAddress = driver.findElement(By.cssSelector("#input-email"));

        PhoneNumber = driver.findElement(By.cssSelector("#input-telephone"));
        Password = driver.findElement(By.cssSelector("#input-password"));
        PasswordConfirmation = driver.findElement(By.cssSelector("#input-confirm"));
        SubscribeNewsletter = driver.findElement(By.cssSelector(".form-horizontal .radio-inline:nth-of-type(2) [type]"));
        PrivacyPolicy = driver.findElement(By.cssSelector("[type='checkbox']"));
        ContinueButton = driver.findElement(By.cssSelector(".btn-primary"));
    }

    public void enterFirstName(String firstName){
        FirstName.clear();
        FirstName.sendKeys(firstName);

    }
    public void enterLastName(String lastName){
        LastName.clear();
        LastName.sendKeys(lastName);
    }
    public void enterEmailAddress(String email){
        EmailAddress.clear();
        EmailAddress.sendKeys(email);
    }

    public void enterPhoneNumber(String phoneNumber){
        PhoneNumber.clear();
        PhoneNumber.sendKeys(phoneNumber);
    }
    public void enterPassword(String password){
        Password.clear();
        Password.sendKeys(password);
    }
    public void enterPasswordConfirmation(String passwordConfirmation){
        PasswordConfirmation.clear();
        PasswordConfirmation.sendKeys(passwordConfirmation);
    }

    public void subscribeNewsletter(){
        SubscribeNewsletter.click();
    }

    public void privacyPolicy(){
        PrivacyPolicy.click();

    }

    public void continueButtonClick(){

        ContinueButton.click();
    }



}