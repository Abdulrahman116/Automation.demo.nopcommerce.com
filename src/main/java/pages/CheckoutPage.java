package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandling;

public class CheckoutPage extends MethodHandling {

    private By countryDropdownList = By.id("BillingNewAddress_CountryId");
    private By stateDropdownList = By.id("BillingNewAddress_StateProvinceId");
    private By cityTextBox = By.id("BillingNewAddress_City");
    private By address1TextBox = By.id("BillingNewAddress_Address1");
    private By postalCodeTextBox = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumberTextBox = By.id("BillingNewAddress_PhoneNumber");
    private By billingContinueButton = By.xpath("//li[1]/div[2]/div/button[contains(text(),'Continue')]");

    //************************************//
    private By shippingMethodButton = By.xpath("//div[2]/button[contains(text(),'Continue')]");
    private By paymentMethodButton = By.xpath("//li[4]/div[2]/div/button[contains(text(),'Continue')]");
    private By paymentInfoButton = By.xpath("//li[5]/div[2]/div/button[contains(text(),'Continue')]");
    private By confirmButton = By.cssSelector(".button-1.confirm-order-next-step-button");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void enterBillinfAddressInfo(String country, String state, String city,
                                        String address1,String postalCode, String phoneNumber) throws InterruptedException {

        selectFromDropdownList(countryDropdownList, country);
        Thread.sleep(150);
        selectFromDropdownList(stateDropdownList, state);
        sendKeys(cityTextBox, city);
        sendKeys(address1TextBox, address1);
        sendKeys(postalCodeTextBox, postalCode);
        sendKeys(phoneNumberTextBox, phoneNumber);
        click(billingContinueButton);
        click(shippingMethodButton);
        click(paymentMethodButton);
        click(paymentInfoButton);

    }
    public OrderDetailsPage confirmTheOrder(){
        click(confirmButton);
        return new OrderDetailsPage(driver);
    }

}