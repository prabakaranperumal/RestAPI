package CommonBusinessScripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import CommonLibraries.ConfigClass;

public class LoginPage extends ConfigClass
{
	@FindBy(name="user_name")
	private WebElement un;
		@FindBy(name="user_password")
	private WebElement pwd;
		@FindBy(id="submitButton")
	private WebElement loginBtn;

	public WebElement getUn() 
	{
		return un;
	}

	public WebElement getPwd() 
	{
		return pwd;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void LoginToVtoiger(String username,String password) throws IOException
	{
		un.sendKeys(username);
		pwd.sendKeys(password);
		loginBtn.click();
	}

}
