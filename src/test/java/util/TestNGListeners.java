package util;



import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.appium.java_client.AppiumDriver;




public class TestNGListeners extends  TestListenerAdapter{
	private static Logger log = Logger.getLogger(TestNGListeners.class);
	 @Override
	    public void onTestSuccess(ITestResult tr) {
	        log.info("Test Success");
	        super.onTestSuccess(tr);
	    }

	    @Override
	    public void onTestFailure(ITestResult tr) {
	        log.error("Test Failure");
	        super.onTestFailure(tr);
	        takeScreenShot(tr);
	    }

	    private void takeScreenShot(ITestResult tr) {
	        UITest b = (UITest) tr.getInstance(); 
	        AppiumDriver currentDirver = b.getDriver();
	        b.takeScreenShot();
	    }

	    @Override
	    public void onTestSkipped(ITestResult tr) {
	        log.error("Test Skipped");
	        super.onTestSkipped(tr);
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        log.info("Test Finsh");
	        super.onTestStart(result);
	    }

	    @Override
	    public void onStart(ITestContext testContext) {
	        log.info("Test Start");
	        super.onStart(testContext);
	    }

	    @Override
	    public void onFinish(ITestContext testContext) {
	        log.info("Test Finish");
	        super.onFinish(testContext);
	    }
}
