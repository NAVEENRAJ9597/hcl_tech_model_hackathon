package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Integer.parseInt(
                                ConfigReader.getProperty("timeout")
                        )
                )
        );
    }

    // =====================================================
    // COMMON POPUP HANDLER
    // =====================================================

    public void closePopupIfPresent() {

        try {

            // wait max 5 sec for popup
            WebDriverWait popupWait =
                    new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement closeBtn = popupWait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath(
                                    "//button[contains(text(),'×') or " +
                                            "contains(text(),'Close') or " +
                                            "contains(@class,'close') or " +
                                            "contains(@class,'modal-close')]"
                            )
                    )
            );

            if (closeBtn.isDisplayed()) {

                popupWait.until(
                        ExpectedConditions.elementToBeClickable(closeBtn)
                );

                closeBtn.click();

                System.out.println("Popup Closed");
            }

        } catch (TimeoutException e) {

            // popup not appeared
            System.out.println("Popup not appeared");

        } catch (Exception e) {

            System.out.println("Unable to close popup");
        }
    }

    // =====================================================
    // SAFE CLICK METHOD
    // =====================================================

    public void click(WebElement element) {

        closePopupIfPresent();

        wait.until(
                ExpectedConditions.elementToBeClickable(element)
        );

        try {

            element.click();

        } catch (ElementClickInterceptedException e) {

            // popup blocked click
            closePopupIfPresent();

            wait.until(
                    ExpectedConditions.elementToBeClickable(element)
            );

            element.click();
        }
    }

    // =====================================================
    // SAFE TYPE METHOD
    // =====================================================

    public void type(WebElement element, String value) {

        closePopupIfPresent();

        wait.until(
                ExpectedConditions.visibilityOf(element)
        );

        element.clear();

        element.sendKeys(value);
    }

    // =====================================================
    // GET TEXT METHOD
    // =====================================================

    public String getText(WebElement element) {

        closePopupIfPresent();

        wait.until(
                ExpectedConditions.visibilityOf(element)
        );

        return element.getText();
    }

    // =====================================================
    // WAIT FOR ELEMENT VISIBLE
    // =====================================================

    public void waitForVisibility(WebElement element) {

        closePopupIfPresent();

        wait.until(
                ExpectedConditions.visibilityOf(element)
        );
    }

    // =====================================================
    // WAIT FOR ELEMENT CLICKABLE
    // =====================================================

    public void waitForClickable(WebElement element) {

        closePopupIfPresent();

        wait.until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }
}