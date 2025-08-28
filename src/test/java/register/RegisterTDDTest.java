package register;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegisterPage;
public class RegisterTDDTest extends BaseTests {

    @DataProvider(name = "registerData")
    public Object[][] getRegisterData() {
        return new Object[][] {
                // fName, lName, email, password, confirmPassword, expectedMessage
                {"John", "Doe", "john.doe@test.com", "Password@123", "Password@123", "Your registration completed"},
                {"Jane", "Smith", "invalidEmail", "Password@123", "Password@123", "Please enter a valid email address."},
                {"Mark", "Lee", "mark.lee@test.com", "Password@123", "WrongPass123", "The password and confirmation password do not match."}
        };
    }

    @Test(dataProvider = "registerData")
    public void testRegister(String fName, String lName, String email, String password,
                             String confirmPassword, String expectedMessage) {

        RegisterPage registerPage = homePage.clickOnRegisterButton();
        registerPage.registerNewAccount(fName, lName, email, password, confirmPassword);
    }
}






















/*package register;

import base.BaseTests;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegisterPage;

import static org.testng.AssertJUnit.assertTrue;

public class RegisterTDDTest extends BaseTests {

    Faker faker;  String email;  String password;   String fName;  String lName; String invalidEmail = "abdo@.com";

    @BeforeClass
    public void setUpData() {
        faker = new Faker();
        fName = faker.name().firstName();  lName = faker.name().lastName();  email = faker.internet().emailAddress();
        password = faker.internet().password(8, 12,
                true, true, true);
    }
    @Test(priority = 1)
    public void testRegisterSuccessfully(){

        RegisterPage registerPage = homePage.clickOnRegisterButton();
        registerPage.registerNewAccountForTDD(fName, lName, email, password);
        /*String actualResult =  registerPage.getValidationMessagePass();
        String expectedResult = "Your registration completed";
        assertTrue(actualResult.contains(expectedResult));*/
    /*}
    @Test(priority = 2)
    public void testRegisterEmailFail(){

        RegisterPage registerPage = homePage.clickOnRegisterButton();
        registerPage.registerNewAccountForTDDFailedEmail(fName, lName, invalidEmail, password);
        /*String actualResult =  registerPage.getValidationMessageEmailFail();
        String expectedResult = "Please enter a valid email address.";
        assertTrue(actualResult.contains(expectedResult));*/
    /*}
    /*@Test(priority = 3)
    public void testRegisterPasswordFail(){

        RegisterPage registerPage = homePage.clickOnRegisterButton();
        registerPage.registerNewAccountForTDDFailedPassword(fName, lName, invalidEmail);
        String actualResult =  registerPage.getValidationMessagePasswordFail();
        String expectedResult = "The password and confirmation password do not match.";
        assertTrue(actualResult.contains(expectedResult));
    }

}*/

