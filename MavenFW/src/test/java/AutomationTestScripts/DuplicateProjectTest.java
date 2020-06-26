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
public class DuplicateProjectTest extends ConfigClass
{

	@Test
	public void DuplicateProject() throws IOException
	{
		HomePage hp = PageFactory.initElements(driver,HomePage.class);
		CreatingNewProject cnp = PageFactory.initElements(driver,CreatingNewProject.class);
		projectInfo ps = PageFactory.initElements(driver, projectInfo.class);
		CommonBusinessScripts.CreateProject cp = PageFactory.initElements(driver, CommonBusinessScripts.CreateProject.class);
		
		hp.navigateToProjects();
		cp.CreateProjectBtn();
		cnp.newProject();
		String actSccMsg = ps.getProjectInfo().getText();
		Reporter.log(actSccMsg,true);
		String  expSccMsg= data.FetchDataFromExcel("TestData", 3, 1);
		Assert.assertTrue(actSccMsg.contains(expSccMsg));
		ps.ClickDuplicateButton();
		String Info = ps.getProjectMoreInfo().getText();
		System.out.println(Info);
		String expInfo = data.FetchDataFromExcel("TestData", 10, 1);
		Assert.assertTrue(Info.contains(expInfo));
		cnp.getSaveButton().click();
		String finSccMsg = ps.getProjectInfo().getText();
		System.out.println(actSccMsg);
		String  finexpMsg= data.FetchDataFromExcel("TestData", 3, 1);
		Assert.assertTrue(finSccMsg.contains(finexpMsg));
		Reporter.log("Duplicate project created Successfully",true);
		System.out.println("-------------------------------------------------");
	}


}
