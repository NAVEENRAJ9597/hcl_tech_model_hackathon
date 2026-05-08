package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
@Listeners(TestListener.class)
public class CartTest extends BaseTest {

    @Test
    public void addProductCartTest() {

        HomePage home = new HomePage(driver);

        ProductPage product = new ProductPage(driver);

        CartPage cart = new CartPage(driver);

        home.clickProducts();

        product.addProductToCart();

        product.continueShopping();

        home.clickCart();

        Assert.assertFalse(cart.getCartProductName().isEmpty()
        );
    }
}