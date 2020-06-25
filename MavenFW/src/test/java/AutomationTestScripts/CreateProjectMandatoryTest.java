package AutomationTestScripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonBusinessScripts.CreatingNewProject;
import CommonBusinessScripts.HomePage;
import CommonBusinessScripts.projectInfo;
import CommonLibraries.ConfigClass;


public class CreateProjectMandatoryTest extends ConfigClass
{
	@Test
	public void CreateProject() throws IOException
	{
		HomePage hp = PageFactory.initElements(driver,HomePage.class);
		CreatingNewProject cnp = PageFactory.initElements(driver,CreatingNewProject.class);
	projectInfo ps = PageFactory.initElements(driver, projectInfo.class);
	CommonBusinessScripts.CreateProject cp = PageFactory.initElements(driver, CommonBusinessScripts.CreateProject.class);
		
		hp.navigateToProjects();
		cp.CreateProjectBtn();
		cnp.newProject();
		String actSccMsg = ps.getProjectInfo().getText();
		String  expSccMsg= data.FetchDataFromExcel("TestData", 3, 1);
		Assert.assertTrue(actSccMsg.contains(expSccMsg));
		ps.moreInformationTab();
		String actSccMsg1 = ps.getProjectMoreInfo().getText();
		String expSccMsg1=data.FetchDataFromExcel("TestData", 3, 1);
		Assert.assertTrue(actSccMsg1.contains(expSccMsg1));
		Reporter.log("project created successfully",true);
		
	}
}
