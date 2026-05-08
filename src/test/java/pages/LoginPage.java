package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement email;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement password;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutBtn;

    @FindBy(xpath = "//p[contains(text(),'incorrect')]")
    WebElement errorMsg;

    public void login(String userEmail,
                      String userPassword) {

        type(email, userEmail);

        type(password, userPassword);

        click(loginBtn);
    }

    public boolean isLogoutVisible() {

        return logoutBtn.isDisplayed();
    }

    public boolean isErrorVisible() {

        return errorMsg.isDisplayed();
    }
}