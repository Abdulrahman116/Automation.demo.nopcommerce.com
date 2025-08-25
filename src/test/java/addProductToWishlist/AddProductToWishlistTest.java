package addProductToWishlist;

import base.BaseTests;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.IPhonePage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.WishlistPage;

import static org.testng.Assert.assertTrue;

public class AddProductToWishlistTest extends BaseTests {

    Faker faker;  String email;  String password;  String product;  String fName;  String lName; String number;
    IPhonePage iPhonePage;

    @BeforeClass
    public void setUpData() {
        faker = new Faker();

        fName = faker.name().firstName();  lName = faker.name().lastName();  email = faker.internet().emailAddress();
        password = faker.internet().password(8, 12,
                true, true, true);      product = "apple";
        number = String.valueOf(faker.number().randomNumber());
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
    public void TestAddProductToWishlist(){

        WishlistPage wishlistPage = iPhonePage.addProductToWishlist();
        wishlistPage.updateAndRemoveFromWishlist(number);
        String actualResult = wishlistPage.getValidationMessage();
        String expectedResult = "The wishlist is empty!";
        assertTrue(actualResult.contains(expectedResult));
    }


}
