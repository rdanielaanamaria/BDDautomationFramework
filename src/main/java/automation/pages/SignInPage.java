package automation.pages;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import automation.utils.Utils;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
//    Locators that we need
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(id = "email_create")
    private WebElement emailSignUpField;

    @FindBy(id = "SubmitCreate")
    private WebElement signUpButton;

//   Define the Actions: log in and sign up

    public void logIn(String email, String passwd){
        emailField.sendKeys(email);
        password.sendKeys(Utils.decode64(passwd));
        signInButton.click();
    }

    public void signUp(String email){
        emailSignUpField.sendKeys(email);
        signInButton.click();
    }
}
