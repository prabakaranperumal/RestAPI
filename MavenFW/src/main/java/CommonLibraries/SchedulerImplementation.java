package CommonLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class SchedulerImplementation implements ITestListener
{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult res)
	{
		String name = res.getName();
		System.out.println("Test Case Failed");
		EventFiringWebDriver efw = new EventFiringWebDriver(ConfigClass.driver);
		File srcFile = efw.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshot/"+name+".png");
		try 
		{
		FileUtils.copyFile(srcFile, destFile);	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
