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
    public String getValidationMessage(){
        return getText(reviewSuccessfullyAddedMessage);
    }
}
