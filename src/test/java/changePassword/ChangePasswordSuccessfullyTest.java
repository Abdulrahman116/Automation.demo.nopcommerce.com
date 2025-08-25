package changePassword;

import base.BaseTests;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.MyAccountPage;
import pages.LoginPage;
import pages.RegisterPage;

import static org.testng.AssertJUnit.assertTrue;

public class ChangePasswordSuccessfullyTest extends BaseTests{

    Faker faker;  String email;  String oldPassword;    String fName;  String lName; String newPassword;
    MyAccountPage myAccountPage;

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
    public void testChangePasswordSuccessfully(){


        MyAccountPage myAccountPage = homePage.clickOnMyAccountButton();
        ChangePasswordPage changePasswordPage = myAccountPage.ClicOnChangePasswordLinkText();
        changePasswordPage.changePasswordPass(oldPassword, newPassword);
        String actualResult = changePasswordPage.getValidationMessagePass();
        String expectedResult = "Password was changed";
        assertTrue(actualResult.contains(expectedResult));
    }
}
