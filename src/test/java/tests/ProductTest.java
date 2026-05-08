package tests;

import base.BaseTest;
import listeners.TestListener;
import org.junit.jupiter.api.Disabled;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
@Listeners(TestListener.class)
public class ProductTest extends BaseTest {

    @Test
    public void searchProductTest() {

        HomePage home = new HomePage(driver);

        ProductPage product = new ProductPage(driver);

        home.clickProducts();

        product.searchProduct("Blue Top");

        Assert.assertTrue(driver.getPageSource().contains("Blue Top")
        );
    }
}