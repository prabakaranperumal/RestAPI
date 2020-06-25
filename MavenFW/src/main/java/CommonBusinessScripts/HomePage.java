package CommonBusinessScripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import CommonLibraries.ConfigClass;

public class HomePage extends ConfigClass
{
	@FindBy(linkText="More")
	private WebElement more;
	@FindBy(name="Projects")
	private WebElement projects;
	@FindBy(xpath="//span[text()=' Administrator']/../following-sibling::td[1]/img")
	private WebElement signOutMousever;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;

	public WebElement getMore() 
	{
		return more;
	}
	
	public WebElement getProjects() {
		return projects;
	}
	
	public WebElement getSignOutMousever() 
	{
		return signOutMousever;
	}

	public WebElement getSignOut() 
	{
		return signOut;
	}
	public void navigateToProjects()
	{
		wlib.moveMousePointer(more);
		projects.click();
	}
	
	public void SingOutFromVtiger() 
	{
		wlib.moveMousePointer(signOutMousever);
		signOut.click();
	}
}
