package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;
@Listeners(TestListener.class)
public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutFlowTest() {

        HomePage home = new HomePage(driver);

        LoginPage login = new LoginPage(driver);

        ProductPage product = new ProductPage(driver);

        CartPage cart = new CartPage(driver);

        CheckoutPage checkout = new CheckoutPage(driver);

        home.clickSignupLogin();

        login.login(ConfigReader.getProperty("email"), ConfigReader.getProperty("password"));

        home.clickProducts();

        product.addProductToCart();

        product.continueShopping();

        home.clickCart();

        cart.proceedCheckout();

        Assert.assertTrue(
                checkout.verifyCheckoutPage()
        );
    }
}