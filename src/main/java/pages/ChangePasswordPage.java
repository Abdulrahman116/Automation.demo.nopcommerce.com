package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class ChangePasswordPage extends MethodHandling{

    private By oldPasswordTextBox = By.id("OldPassword");
    private By newPasswordTextBox = By.id("NewPassword");
    private By confirmNewPasswordTextBox = By.id("ConfirmNewPassword");
    private By changePasswordButton = By.cssSelector(".button-1.change-password-button");
    private By changePasswordSuccessfullyMessage = By.cssSelector(".content");


    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }
    public void changePasswordPass(String oldPassword, String newPassword){
        sendKeys(oldPasswordTextBox, oldPassword);
        sendKeys(newPasswordTextBox, newPassword);
        sendKeys(confirmNewPasswordTextBox, newPassword);
        click(changePasswordButton);
    }
    public String getValidationMessagePass(){
       return getText(changePasswordSuccessfullyMessage);
    }
}
