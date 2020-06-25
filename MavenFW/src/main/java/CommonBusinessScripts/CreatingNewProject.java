package CommonBusinessScripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import CommonLibraries.ConfigClass;

public class CreatingNewProject extends ConfigClass
{
	@FindBy(name="projectname")
	private WebElement projectname;
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveButton;
	
	public WebElement getProjectname() {
		return projectname;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	public void newProject() throws IOException
	{
		String projectNameTxt = data.FetchDataFromExcel("TestData", 3, 1);
		projectname.sendKeys(projectNameTxt);
		saveButton.click();
	}
	
	public void EditExistingProject() throws IOException
	{
		String projectNameTxt = data.FetchDataFromExcel("TestData", 9, 1);
		projectname.sendKeys(projectNameTxt);
		saveButton.click();
	}
	
}
