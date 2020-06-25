package CommonLibraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverScript 
{
	public void waitForElement(WebElement element)
	{
	WebDriverWait wait = new WebDriverWait(ConfigClass.driver, 20);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) element));
	}
	
	public void alertAccept() 
	{
		ConfigClass.driver.switchTo().alert().accept();
	}
	
	public String getAlertMsg() 
	{
		return ConfigClass.driver.switchTo().alert().getText();
	}
	
	public void switchToFrame(WebElement element)
	{
		ConfigClass.driver.switchTo().frame(element);
	}
	
	public void switchToDefaultPage() 
	{
		ConfigClass.driver.switchTo().defaultContent();
	}
	
	public void moveMousePointer(WebElement element) 
	{
	Actions act = new Actions(ConfigClass.driver);
	act.moveToElement(element).perform();
	}
	
	public void selectItemFromList(WebElement listbox,String itemname)
	{
	Select s = new Select(listbox);
	s.selectByVisibleText(itemname);
	}
}
