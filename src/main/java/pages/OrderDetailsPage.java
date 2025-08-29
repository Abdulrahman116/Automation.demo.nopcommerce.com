package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class OrderDetailsPage extends MethodHandling {

    private By orderDetailsLink = By.linkText("Click here for order details.");
    private By PDFinvoiceButton = By.linkText("PDF Invoice");

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }
    public void downloadTheInvoice(){
        click(orderDetailsLink);
        click(PDFinvoiceButton);
    }

}
