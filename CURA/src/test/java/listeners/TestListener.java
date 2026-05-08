package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverFactory;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent =
            ExtentManager.getInstance();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String path =
                ScreenshotUtil.captureScreenshot(
                        DriverFactory.getDriver(),
                        result.getName());

        test.fail("Test Failed");

        try {

            test.fail("Screenshot")
                    .addScreenCaptureFromPath(path);

        } catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println(
                "Screenshot captured for failed test: "
                        + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println(
                "Extent Report Generated");
    }
}