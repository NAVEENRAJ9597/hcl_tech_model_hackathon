package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage extends BasePage {

    public ValidationPage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "name")
    WebElement nameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement emailField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupBtn;

    public void clickSignup() {

        click(signupBtn);
    }

    public void enterInvalidEmail() {

        type(emailField, "invalidEmail");
    }

    public String getNameValidationMessage() {

        return nameField.getAttribute(
                "validationMessage"
        );
    }

    public String getEmailValidationMessage() {

        return emailField.getAttribute(
                "validationMessage"
        );
    }
}


