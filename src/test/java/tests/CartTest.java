package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class CartTest extends BaseTest {

    @Test
    public void addProductCartTest() {

        HomePage home =
                new HomePage(driver);

        ProductPage product =
                new ProductPage(driver);

        CartPage cart =
                new CartPage(driver);

        home.clickProducts();

        product.addProductToCart();

        product.continueShopping();

        home.clickCart();

        Assert.assertFalse(
                cart.getCartProductName()
                        .isEmpty()
        );
    }
}