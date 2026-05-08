package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }

    public boolean verifyCheckoutPage() {

        return driver.getPageSource()
                .contains("Address Details");
    }
}