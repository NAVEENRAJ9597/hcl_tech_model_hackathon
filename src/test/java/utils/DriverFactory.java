package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    static WebDriver driver;

    public static WebDriver initializeDriver() {

        String browser =
                ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        return driver;
    }
}