package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class ShoppingCartPage extends MethodHandling {

    private By checkBox = By.id("termsofservice");
    private By checkoutButton = By.id("checkout");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public CheckoutPage addProductToCheckoutPage(){
        click(checkBox);
        click(checkoutButton);
        return new CheckoutPage(driver);
    }
}
