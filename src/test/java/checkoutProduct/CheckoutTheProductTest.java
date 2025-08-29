package checkoutProduct;

import base.BaseTests;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTheProductTest extends BaseTests{

    Faker faker;  String email;  String password;  String product;  String fName;  String lName;
    String country = "Egypt"; String state = "Cairo"; String city = "El-Salam"; String address1 = "Espiko - Abd 700";
    String postalCode = "52314"; String phoneNumber = "01125412367";

    IPhonePage iPhonePage; ShoppingCartPage shoppingCartPage; CheckoutPage checkoutPage; OrderDetailsPage orderDetailsPage;

    @BeforeClass
    public void setUpData() {
        faker = new Faker();

        fName = faker.name().firstName();  lName = faker.name().lastName();  email = faker.internet().emailAddress();
        password = faker.internet().password(8, 12,
                true, true, true);
        product = "apple";
    }

    @Test(priority = 1)
    public void testRegisterSuccessfully() {

        RegisterPage registerPage = homePage.clickOnRegisterButton();
        registerPage.registerNewAccount(fName, lName, email, password);
    }
    @Test(priority = 2)
    public void testLoginSuccessfully() {

        LoginPage loginPage = homePage.clickOnLoginButton();
        loginPage.enterEmailAndPassword(email, password);
    }
    @Test(priority = 3)
    public void testSearchTheProduct(){
        iPhonePage = homePage.searchForProduct(product);
    }
    @Test(priority = 4)
    public void testAddTheProductToCart(){
        shoppingCartPage = iPhonePage.addProductToCart();
    }
    @Test(priority = 5)
    public void testAddTheProductToChecokout(){
        checkoutPage = shoppingCartPage.addProductToCheckoutPage();
    }
    @Test(priority = 6)
    public void testFinishBillingInfo()throws InterruptedException{
        checkoutPage.enterBillinfAddressInfo(country, state, city, address1, postalCode, phoneNumber);
    }
    @Test(priority = 7)
    public void testConfirmOrderDownloadInvoice() throws InterruptedException {
        orderDetailsPage = checkoutPage.confirmTheOrder();
        orderDetailsPage.downloadTheInvoice();
        Thread.sleep(5000);
    }

}
