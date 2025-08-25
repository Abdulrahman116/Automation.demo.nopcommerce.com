package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class HomePage extends MethodHandling{


    private By loginButton = By.linkText("Log in");
    private By registerButton = By.linkText("Register");
    private By searchTextBox = By.id("small-searchterms");
    private By IPhone16 = By.xpath("//span[contains(text(),'Apple iPhone 16 128GB')]");
    private By myAccountButton = By.linkText("My account");


    public HomePage(WebDriver driver){
        super(driver);
    }

    public IPhonePage searchForProduct(String product){

        sendKeys(searchTextBox, product);
        click(IPhone16);
        return new IPhonePage(driver);
    }
    public LoginPage clickOnLoginButton(){
        click(loginButton);
        return new LoginPage(driver);
    }
    public RegisterPage clickOnRegisterButton(){
        click(registerButton);
        return new RegisterPage(driver);
    }
    public MyAccountPage clickOnMyAccountButton(){
        click(myAccountButton);
        return new MyAccountPage(driver);
    }
}
