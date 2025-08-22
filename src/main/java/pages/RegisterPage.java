package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class RegisterPage extends MethodHandling{

    private By firstNameTextBox = By.id("FirstName");    private By lastNameTextBox = By.id("LastName");
    private By emailTextBox = By.id("Email");            private By passwordTextBox = By.id("Password");
    private By confirmPasswordTextBox = By.id("ConfirmPassword");  private By registerButton = By.id("register-button");
    private By logoutButton = By.linkText("Log out");

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
}
