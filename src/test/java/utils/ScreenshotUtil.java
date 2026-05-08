package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(
            WebDriver driver,
            String testName
    ) {

        String timeStamp =
                new SimpleDateFormat(
                        "yyyyMMdd_HHmmss"
                ).format(new Date());

        String path =
                "screenshots/" +
                        testName + "_" +
                        timeStamp + ".png";

        File src =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(src, new File(path));

        } catch (Exception e) {

            e.printStackTrace();
        }

        return path;
    }
}