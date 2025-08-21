package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class HomePage extends MethodHandling{


    private By loginButton = By.linkText("Log in");


    public HomePage(WebDriver driver){
        super(driver);
    }

    public LoginPage clickOnLoginButton(){
        click(loginButton);
        return new LoginPage(driver);
    }
}
