package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class LoginPage extends MethodHandling {

    private By emailTextBox = By.id("Email");
    private By passwordTextBox = By.id("Password");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAndPassword(String email, String password){

        sendKeys(emailTextBox, email);
        sendKeys(passwordTextBox, password);
        click(loginButton);
    }



}
