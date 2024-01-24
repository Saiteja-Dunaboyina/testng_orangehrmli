package practicetestng.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("OnTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("OnTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("OnTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("OnTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("OnStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("OnFinish");
	}
	
	

}
