package pages;

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
<<<<<<< HEAD
            LastName.clear();
            LastName.sendKeys(lastName);
    }
    public void enterEmailAddress(String email){
    EmailAddress.clear();
    EmailAddress.sendKeys(email);
=======
        LastName.clear();
        LastName.sendKeys(lastName);
    }
    public void enterEmailAddress(String email){
        EmailAddress.clear();
        EmailAddress.sendKeys(email);
>>>>>>> 05f6de3e67759c51452fa50f7635f3ff2036d723
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
<<<<<<< HEAD
       PrivacyPolicy.click();
=======
        PrivacyPolicy.click();
<<<<<<< HEAD:src/main/java/Pages/RegistrationPage.java
>>>>>>> 05f6de3e67759c51452fa50f7635f3ff2036d723

=======
>>>>>>> d7bc7132e25eccf3af5526da460635c23135e072:src/main/java/pages/RegistrationPage.java
    }

    public void continueButtonClick(){
        ContinueButton.click();
    }

<<<<<<< HEAD:src/main/java/Pages/RegistrationPage.java


<<<<<<< HEAD
}
=======
}
>>>>>>> 05f6de3e67759c51452fa50f7635f3ff2036d723
=======
}
>>>>>>> d7bc7132e25eccf3af5526da460635c23135e072:src/main/java/pages/RegistrationPage.java
