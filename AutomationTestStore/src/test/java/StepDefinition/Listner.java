package StepDefinition;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listner implements ITestListener{
	
	@Override
	public void onTestSuccess(ITestResult res) {
		System.out.println(res.getName()+" Passed");
	}
	@Override
	public void onTestFailure(ITestResult res) {
		System.out.println(res.getMethod()+" Failed");
	}
	
	
	

}
