package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class RegisterPage extends MethodHandling{

    private By firstNameTextBox = By.id("FirstName");    private By lastNameTextBox = By.id("LastName");
    private By emailTextBox = By.id("Email");            private By passwordTextBox = By.id("Password");
    private By confirmPasswordTextBox = By.id("ConfirmPassword");  private By registerButton = By.id("register-button");
    private By logoutButton = By.linkText("Log out");
    private By registerSuccessfullyMessage = By.xpath("//div[contains(text(),'Your registration completed')]");
    private By registerEmailFailMessage = By.id("Email-error");
    private By registerPasswordFailMessage = By.id("ConfirmPassword-error");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerNewAccount(String fName,String lName,String email ,  String Password){

        sendKeys(firstNameTextBox, fName);
        sendKeys(lastNameTextBox, lName);
        sendKeys(emailTextBox, email);
        sendKeys(passwordTextBox, Password);
        sendKeys(confirmPasswordTextBox, Password);
        click(registerButton);
        click(logoutButton);
    }
    public void registerNewAccountForTDD(String fName,String lName,String email ,  String Password){

        sendKeys(firstNameTextBox, fName);
        sendKeys(lastNameTextBox, lName);
        sendKeys(emailTextBox, email);
        sendKeys(passwordTextBox, Password);
        sendKeys(confirmPasswordTextBox, Password);
        click(registerButton);
        click(logoutButton);
    }
    public void registerNewAccountForTDDFailedEmail(String fName,String lName,String email ,  String Password){

        sendKeys(firstNameTextBox, fName);
        sendKeys(lastNameTextBox, lName);
        sendKeys(emailTextBox, email);
        sendKeys(passwordTextBox, Password);
        sendKeys(confirmPasswordTextBox, Password);
        click(registerButton);
    }
    public void registerNewAccountForTDDFailedPassword(String fName,String lName,String email){

        sendKeys(firstNameTextBox, fName);
        sendKeys(lastNameTextBox, lName);
        sendKeys(emailTextBox, email);
        sendKeys(passwordTextBox, "12345678");
        sendKeys(confirmPasswordTextBox, "87654321");
        click(registerButton);
    }

    public void registerNewAccount(String fName, String lName, String email, String password, String confirmPassword) {
        sendKeys(firstNameTextBox, fName);
        sendKeys(lastNameTextBox, lName);
        sendKeys(emailTextBox, email);
        sendKeys(passwordTextBox, password);
        sendKeys(confirmPasswordTextBox, confirmPassword);
        click(registerButton);
    }



    public String getValidationMessagePass(){
       return getText(registerSuccessfullyMessage);
    }
    public String getValidationMessageEmailFail(){
        return getText(registerEmailFailMessage);
    }
    public String getValidationMessagePasswordFail(){
        return getText(registerPasswordFailMessage);
    }
}
