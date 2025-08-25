package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class IPhonePage extends MethodHandling{

    private By addReviewLinkText = By.linkText("Add your review");
    private By reviewTitleTextBox = By.id("AddProductReview_Title");
    private By reviewTextBox = By.id("AddProductReview_ReviewText");
    private By rating = By.id("addproductrating_5");
    private By submitReviewButton = By.id("add-review");
    private By reviewSuccessfullyAddedMessage =
            By.xpath("//p[contains(text() ,'Product review is successfully added.')]");
    private By requiredTitleReviewMessage =
            By.xpath("//span[contains(text() ,'Review title is required.')]");
    private By emailFriendButton = By.xpath("//button[contains(text() ,'Email a friend')]");
    private By wishlistButton = By.id("add-to-wishlist-button-21");
    private By wishlistLinkText = By.linkText("wishlist");

    public IPhonePage(WebDriver driver) {
        super(driver);
    }

    public void addReviewForIPhone(String reviewTitle, String reviewText){

        click(addReviewLinkText);
        sendKeys(reviewTitleTextBox, reviewTitle);
        sendKeys(reviewTextBox, reviewText);
        click(rating);
        click(submitReviewButton);
    }
    public void addReviewForIPhoneFail(String reviewText){

        click(addReviewLinkText);
        sendKeys(reviewTextBox, reviewText);
        click(rating);
        click(submitReviewButton);
    }
    public EmailFriendPage clickOnEmailFriend(){
        click(emailFriendButton);
        return new EmailFriendPage(driver);
    }
    public WishlistPage addProductToWishlist(){
        click(wishlistButton);
        click(wishlistLinkText);
        return new WishlistPage(driver);
    }
    public String getValidationMessage(){
        return getText(reviewSuccessfullyAddedMessage);
    }
    public String getValidationMessageFail(){
        return getText(requiredTitleReviewMessage);
    }
}
