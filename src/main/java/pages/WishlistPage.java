package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class WishlistPage extends MethodHandling {

    private By quantity = By.cssSelector(".qty-input");
    private By updateWishlistButon = By.id("updatecart");
    private By removefromWishlist = By.cssSelector(".remove-btn");
    private By removeProductSuccessfullyMessage = By.cssSelector(".no-data");
    public WishlistPage(WebDriver driver) {
        super(driver);
    }
    public void updateAndRemoveFromWishlist(String Number){
        sendKeys(quantity, Number);
        click(updateWishlistButon);
        click(removefromWishlist);
    }
    public String getValidationMessage(){
        return getText(removeProductSuccessfullyMessage);
    }


}
