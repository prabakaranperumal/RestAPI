package AutomationTestScripts;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonBusinessScripts.CreateProject;
import CommonBusinessScripts.CreatingNewProject;
import CommonBusinessScripts.HomePage;
import CommonLibraries.ConfigClass;
@Listeners(CommonLibraries.SchedulerImplementation.class)
public class CreateProjectWoutMandatoryTest extends ConfigClass
{
	@Test(priority=2)
	public void CreateProjectErr() throws IOException
	{
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		CreatingNewProject cnp = PageFactory.initElements(driver, CreatingNewProject.class);
		CreateProject cp = PageFactory.initElements(driver, CreateProject.class);
		
		hp.navigateToProjects();
		cp.CreateProjectBtn();
		cnp.getProjectname().sendKeys(" ");
		cnp.getSaveButton().click();
		Alert alert = driver.switchTo().alert();
		String ErrMsg = alert.getText();
//		System.out.println(ErrMsg);
		alert.accept();
		Assert.assertEquals(ErrMsg, data.FetchDataFromExcel("TestData", 4, 1));
		Reporter.log("Error message validation done",true);
	}
}
