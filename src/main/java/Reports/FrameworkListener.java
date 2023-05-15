package Reports;

import org.testng.*;
import util.ReporterUtil;

public class FrameworkListener implements ISuiteListener, ITestListener {

    @Override
    public void onStart(ISuite suite) {
        ReporterUtil.createReport(suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        ReporterUtil.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ReporterUtil.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReporterUtil.getTest().pass("Test Passed!!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ReporterUtil.getTest().fail("Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReporterUtil.getTest().skip("Test Skipped");
    }

}
