package CommonBusinessScripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import CommonLibraries.ConfigClass;

public class projectInfo extends ConfigClass
{
	@FindBy(className = "dvHeaderText")
	private WebElement projectInfo;
	
	@FindBy(className = "dvtUnSelectedCell")
	private WebElement moreInformation;
	
	@FindBy(className = "lvtHeaderText")
	private WebElement projectMoreInfo;
	

	@FindBy(name="Edit")
	private WebElement editBtn;
	
	@FindBy(name="Duplicate")
	private WebElement duplicateBtn;
	
	@FindBy(name="Delete")
	private WebElement deleteBtn;
	
	public WebElement getMoreInformation()
	{
		return moreInformation;
	}

	public WebElement getProjectInfo() {
		return projectInfo;
	}
	public WebElement getProjectMoreInfo() {
		return projectMoreInfo;
	}
	public WebElement getEditBtn() {
		return editBtn;
	}

	public void moreInformationTab() throws IOException 
	{
		moreInformation.click();
		
	}
	
	public void ClickEditButton()
	{
		editBtn.click();
	}
	
	public void ClickDuplicateButton()
	{
		duplicateBtn.click();
	}
	
	public void ClickDeleteButton()
	{
		deleteBtn.click();
	}

	public WebElement getDuplicateBtn() {
		return duplicateBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	
	


}
