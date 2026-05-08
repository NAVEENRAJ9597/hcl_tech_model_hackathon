package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ValidationPage;

public class ValidationTest extends BaseTest {

    @Test
    public void emptyFieldValidationTest() {

        HomePage home =
                new HomePage(driver);

        ValidationPage validation =
                new ValidationPage(driver);

        home.clickSignupLogin();

        validation.clickSignup();

        Assert.assertFalse(
                validation
                        .getNameValidationMessage()
                        .isEmpty()
        );
    }

    @Test
    public void invalidEmailValidationTest() {

        HomePage home =
                new HomePage(driver);

        ValidationPage validation =
                new ValidationPage(driver);

        home.clickSignupLogin();

        validation.enterInvalidEmail();

        validation.clickSignup();

        Assert.assertFalse(
                validation
                        .getEmailValidationMessage()
                        .isEmpty()
        );
    }
}