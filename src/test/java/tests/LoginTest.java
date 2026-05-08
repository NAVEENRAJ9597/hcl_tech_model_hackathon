package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.DataProviders;
import listeners.TestListener;

@Listeners(TestListener.class)

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData",
            dataProviderClass = DataProviders.class)

    public void loginTest(String email, String password, boolean expected) {

        HomePage home = new HomePage(driver);

        LoginPage login = new LoginPage(driver);

        home.clickSignupLogin();

        login.login(email, password);

        if (expected) {

            Assert.assertTrue(login.isLogoutVisible());

        } else {

            Assert.assertTrue(login.isErrorVisible());
        }
    }


}