package addReview;

import base.BaseTests;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.IPhonePage;
import pages.LoginPage;
import pages.RegisterPage;

import static org.testng.Assert.assertTrue;

public class AddReviewTestFail extends BaseTests {

    Faker faker;  String email;  String password;  String product;  String fName;  String lName;  String reviewText;
    IPhonePage iPhonePage;

    @BeforeClass
    public void setUpData() {
        faker = new Faker();

        fName = faker.name().firstName();  lName = faker.name().lastName();  email = faker.internet().emailAddress();
        reviewText = faker.commerce().material();
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
    public void testAddReviewSuccessfully() throws InterruptedException {
        iPhonePage.addReviewForIPhoneFail(reviewText);
        String actualResult = iPhonePage.getValidationMessageFail();
        String expectedResult = "Review title is required.";
        assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(5000);
    }


}
