package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[@class='cart_description']/h4/a")
    WebElement productName;

    @FindBy(className = "cart_quantity_delete")
    WebElement deleteBtn;

    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    WebElement checkoutBtn;

    public String getCartProductName() {

        return getText(productName);
    }

    public void removeProduct() {

        click(deleteBtn);
    }

    public void proceedCheckout() {

        click(checkoutBtn);
    }
}