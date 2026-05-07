package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverFactory;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        ScreenshotUtil.captureScreenshot(
                DriverFactory.getDriver(),
                result.getName());

        System.out.println(
                "Screenshot captured for failed test: "
                        + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Test Started");
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("Test Finished");
    }
}