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
@Listeners(CommonLibraries.SchedulerImplementation.class)
public class EditProjectTest extends ConfigClass
{
	@Test
	public void EditProject() throws IOException
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
			ps.ClickEditButton();
			cnp.getProjectname().clear();
			cnp.EditExistingProject();
			String editSccMsg = ps.getProjectInfo().getText();
			String  expEditSccMsg= data.FetchDataFromExcel("TestData", 9, 1);
			Assert.assertTrue(editSccMsg.contains(expEditSccMsg));
			Reporter.log("Project Edited Successfully",true);
			System.out.println("-------------");
	}	
}
