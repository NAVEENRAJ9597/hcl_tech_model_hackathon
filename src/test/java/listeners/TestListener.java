package listeners;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.ScreenshotUtil;

public class TestListener
        extends BaseTest
        implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTestManager.setTest(
                ExtentManager
                        .getReportInstance()
                        .createTest(result.getName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest()
                .log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        driver,
                        result.getName()
                );

        ExtentTestManager.getTest()
                .fail(result.getThrowable())
                .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager.getReportInstance().flush();
    }
}