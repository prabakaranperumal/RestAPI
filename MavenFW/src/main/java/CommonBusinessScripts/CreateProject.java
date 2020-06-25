package CommonBusinessScripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import CommonLibraries.ConfigClass;


public class CreateProject extends ConfigClass
{
	@FindBy(css="img[title='Create Projects...']")
	private WebElement createProjects;
	
	@FindBy(className="hdrLink")
	private WebElement ProjectsLink;
	
	public WebElement getCreateProjects() {
		return createProjects;
	}
	public void CreateProjectBtn()
	{
		createProjects.click();
	}
	public WebElement getProjectsLink() {
		return ProjectsLink;
	}
	
}
