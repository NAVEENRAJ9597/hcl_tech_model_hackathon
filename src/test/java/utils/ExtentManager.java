package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String reportPath =
                    "reports/ExtentReport.html";

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(reportPath);

            reporter.config().setReportName(
                    "Automation Report"
            );

            extent = new ExtentReports();

            extent.attachReporter(reporter);
        }

        return extent;
    }
}