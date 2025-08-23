package emailFriend;

import base.BaseTests;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EmailFriendPage;
import pages.IPhonePage;
import pages.LoginPage;
import pages.RegisterPage;

import static org.testng.Assert.assertTrue;

public class SendEmailTestFail extends BaseTests{

    Faker faker;  String email;  String password;  String product;  String fName;  String lName;
    String friendEmail = "Ahmed@.com"; String personalMessage;
    IPhonePage iPhonePage;

    @BeforeClass
    public void setUpData() {
        faker = new Faker();

        fName = faker.name().firstName();  lName = faker.name().lastName();  email = faker.internet().emailAddress();
        password = faker.internet().password(8, 12,
                true, true, true);      product = "apple";
                personalMessage = faker.lorem().sentence();
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
    public void testEmailFriendFail(){
        EmailFriendPage emailFriendPage = iPhonePage.clickOnEmailFriend();
        emailFriendPage.sendEmailSuccessfully(friendEmail, personalMessage);
        String actualResult = emailFriendPage.getValidationMessageFail();
        String expectedResult = "Please enter a valid email address.";
        assertTrue(actualResult.contains(expectedResult));
    }


}
