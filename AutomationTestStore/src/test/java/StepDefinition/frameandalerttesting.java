package StepDefinition;

import org.testng.annotations.Test;

import Pages.frameandalerttestingpage;

public class frameandalerttesting extends Baseclass {

	@Test
	public void teststarts() throws InterruptedException {
		frameandalerttestingpage fatp=new frameandalerttestingpage(driver,action,wait,verify);
//		fatp.method1();
		fatp.method2();
	}

}
