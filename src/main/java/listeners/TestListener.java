package listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


/**
 * This class implements ITestListener to perform tasks upon status of testcase(start, pass, fail, etc.)
 *
 * For now, it contains reporting and logging actions.
 *
 * @author Rahul Jadhwani [30/05/2022]
 */
public class TestListener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" has started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" has passed");
        Reporter.log(result.getMethod().getMethodName()+" has passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.warn(result.getMethod().getMethodName()+" has failed");
        Reporter.log(result.getMethod().getMethodName()+" has failed");
        Reporter.log(result.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName()+" was skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
