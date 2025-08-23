package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class EmailFriendPage extends MethodHandling {

    private By friendEmailTextBox = By.id("FriendEmail");
    private By personalMessageTextBox = By.id("PersonalMessage");
    private By sendEmailButton = By.xpath("//button[contains(text() ,'Send email')]");
    private By sendEmailSuccessfullyMessage = By.xpath("//div[contains(text() ,'Your message has been sent.')]");
    private By sendEmailUnsuccessfullyMessage = By.id("FriendEmail-error");

    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }
    public void sendEmailSuccessfully(String friendEmail, String personalMessage){
        sendKeys(friendEmailTextBox, friendEmail);
        sendKeys(personalMessageTextBox, personalMessage);
        click(sendEmailButton);
    }
    public String getValidationMessagePass(){
        return getText(sendEmailSuccessfullyMessage);
    }
    public String getValidationMessageFail(){
        return getText(sendEmailUnsuccessfullyMessage);
    }

}
