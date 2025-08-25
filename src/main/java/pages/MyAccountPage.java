package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class MyAccountPage extends MethodHandling{

    private By changePasswordLinkText = By.linkText("Change password");
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public ChangePasswordPage ClicOnChangePasswordLinkText(){
        click(changePasswordLinkText);
        return new ChangePasswordPage(driver);
    }
}
