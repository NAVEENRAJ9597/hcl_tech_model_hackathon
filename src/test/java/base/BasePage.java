package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    WebDriverWait wait;

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

    // =========================================
    // HANDLE AUTOMATION EXERCISE POPUP
    // =========================================

    public void closePopupIfPresent() {

        try {

            // Find all iframes
            List<WebElement> iframes =
                    driver.findElements(By.tagName("iframe"));

            for (WebElement frame : iframes) {

                try {

                    driver.switchTo().frame(frame);

                    List<WebElement> closeButtons =
                            driver.findElements(
                                    By.id("dismiss-button")
                            );

                    if (closeButtons.size() > 0) {

                        closeButtons.get(0).click();

                        System.out.println(
                                "Popup closed successfully"
                        );

                        driver.switchTo().defaultContent();

                        return;
                    }

                    driver.switchTo().defaultContent();

                } catch (Exception e) {

                    driver.switchTo().defaultContent();
                }
            }

        } catch (Exception e) {

            driver.switchTo().defaultContent();
        }
    }

    // =========================================
    // CLICK METHOD
    // =========================================

    public void click(WebElement element) {

        try {

            closePopupIfPresent();

            wait.until(
                    ExpectedConditions.elementToBeClickable(element)
            );

            element.click();

        } catch (ElementClickInterceptedException e) {

            closePopupIfPresent();

            wait.until(
                    ExpectedConditions.elementToBeClickable(element)
            );

            element.click();
        }
    }

    // =========================================
    // TYPE METHOD
    // =========================================

    public void type(WebElement element,
                     String value) {

        wait.until(
                ExpectedConditions.visibilityOf(element)
        );

        element.clear();

        element.sendKeys(value);
    }

    // =========================================
    // GET TEXT METHOD
    // =========================================

    public String getText(WebElement element) {

        wait.until(
                ExpectedConditions.visibilityOf(element)
        );

        return element.getText();
    }

    // =========================================
    // DISPLAY CHECK
    // =========================================

    public boolean isDisplayed(
            WebElement element
    ) {

        wait.until(
                ExpectedConditions.visibilityOf(element)
        );

        return element.isDisplayed();
    }
}