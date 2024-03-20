package locators;

import org.openqa.selenium.By;

public class RegistrationPageLocators {
    public static final By FIRST_NAME_INPUT = By.cssSelector("#input-firstname");
    public static final By LAST_NAME_INPUT = By.cssSelector("#input-lastname");
    public static final By EMAIL_INPUT = By.cssSelector("#input-email");
    public static final By PHONE_INPUT = By.cssSelector("#input-telephone");
    public static final By PASSWORD_INPUT = By.cssSelector("#input-password");
    public static final By PASSWORD_CONFIRM_INPUT = By.cssSelector("#input-confirm");
    public static final By SUBSCRIBE_BUTTON = By.cssSelector(".form-horizontal .radio-inline:nth-of-type(2) [type]");
    public static final By PRIVACY_POLICY_BUTTON = By.cssSelector("[type='checkbox']");
    public static final By CONTINUE_BUTTON = By.cssSelector(".btn-primary");
}
