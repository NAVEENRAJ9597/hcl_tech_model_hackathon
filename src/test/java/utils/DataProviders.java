package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][]{

                {
                        ConfigReader.getProperty("email"),
                        ConfigReader.getProperty("password"),
                        true
                },

                {
                        ConfigReader.getProperty("email"),
                        "WrongPassword",
                        false
                }
        };
    }
}