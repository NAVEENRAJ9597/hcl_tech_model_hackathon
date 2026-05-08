
package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_product")
    WebElement searchBox;

    @FindBy(id = "submit_search")
    WebElement searchBtn;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    WebElement firstProduct;

    @FindBy(xpath = "(//a[contains(text(),'Add to cart')])[1]")
    WebElement addToCartBtn;

    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    WebElement continueShoppingBtn;

    public void searchProduct(String product) {

        type(searchBox, product);

        click(searchBtn);
    }

    public void openFirstProduct() {

        click(firstProduct);
    }

    public void addProductToCart() {

        click(addToCartBtn);
    }

    public void continueShopping() {

        click(continueShoppingBtn);
    }
}