package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTests {

    String email = "abdobedo391@gmail.com";
    String password = "Test@1234";

    @Test
    public void testLoginSuccessfully() throws InterruptedException {

        LoginPage loginPage = homePage.clickOnLoginButton();
        loginPage.enterEmailAndPassword(email, password);
        Thread.sleep(5000);
    }
}
