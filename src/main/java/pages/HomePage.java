package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class HomePage extends MethodHandling{


    //private By formAuthentication = By.linkText("Form Authentication");


    public HomePage(WebDriver driver){
        super(driver);
    }

    /*public LoginPage clickOnFormAuthenticationLink(){
        click(formAuthentication);
        return new LoginPage(driver);
    }*/
}
