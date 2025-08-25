package changePassword;

import base.BaseTests;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterPage;

import static org.testng.AssertJUnit.assertTrue;

public class ChangePasswordFailTest extends BaseTests{

    Faker faker;  String email;  String oldPassword;    String fName;  String lName; String newPassword;

    @BeforeClass
    public void setUpData() {
        faker = new Faker();

        fName = faker.name().firstName();  lName = faker.name().lastName();  email = faker.internet().emailAddress();
        oldPassword = faker.internet().password(8, 12,
                true, true, true);
        newPassword = faker.internet().password(8, 12,
                true, true, true);
    }

    @Test(priority = 1)
    public void testRegisterSuccessfully() {

        RegisterPage registerPage = homePage.clickOnRegisterButton();
        registerPage.registerNewAccount(fName, lName, email, oldPassword);
    }
    @Test(priority = 2)
    public void testLoginSuccessfully() {

        LoginPage loginPage = homePage.clickOnLoginButton();
        loginPage.enterEmailAndPassword(email, oldPassword);
    }
    @Test(priority = 3)
    public void testChangePasswordFail(){

        MyAccountPage myAccountPage = homePage.clickOnMyAccountButton();
        ChangePasswordPage changePasswordPage = myAccountPage.ClicOnChangePasswordLinkText();
        changePasswordPage.changePasswordPass(newPassword, newPassword);
        String actualResult = changePasswordPage.getValidationMessageFail();
        String expectedResult = "Old password doesn't match";
        assertTrue(actualResult.contains(expectedResult));
    }

}
