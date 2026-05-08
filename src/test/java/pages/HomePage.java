package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    WebElement signupLoginBtn;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    WebElement productsBtn;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    WebElement cartBtn;

    public void clickSignupLogin() {

        click(signupLoginBtn);
    }

    public void clickProducts() {

        click(productsBtn);
    }

    public void clickCart() {

        click(cartBtn);
    }
}