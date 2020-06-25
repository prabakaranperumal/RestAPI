package CommonLibraries;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import CommonBusinessScripts.HomePage;
import CommonBusinessScripts.LoginPage;

@Listeners(CommonLibraries.SchedulerImplementation.class)
public class ConfigClass 
{
	public DriverScript wlib = new DriverScript();
	public static WebDriver driver=null;
	public FileData data = new FileData();
	@BeforeSuite
	public void configBS()
	{
		System.out.println("DB connect");
	}
	@Parameters("browser")
//	provide (String browser) in configBC() as argument 
//	and comment data fetch property inside configBC() and Run .xml file for cross browsing.
	
	@BeforeClass
	public void configBC() throws IOException
	{
		String browser = data.fetchDataFromProperty("browser");
		System.out.println("Launch Browser");
		if (browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();	
		}
//		else if (browser.equals("firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
////			driver=new FirefoxDriver();
//		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void configBM() throws IOException
	{
		String un = data.fetchDataFromProperty("username");
		String pwd = data.fetchDataFromProperty("password");
		driver.get(data.fetchDataFromProperty("url"));
		LoginPage lp = PageFactory.initElements(driver,LoginPage.class);
		lp.LoginToVtoiger(un, pwd);
		System.out.println("Login done");
		
		String HomeTitle = driver.getTitle();
//		Hard Assert
		boolean flag1 = HomeTitle.contains(data.FetchDataFromExcel("TestData", 2, 1));
		Assert.assertTrue(flag1);
	}
	@AfterMethod
	public void configAM() throws IOException
	{
		HomePage lp = PageFactory.initElements(driver,HomePage.class);
		lp.SingOutFromVtiger();
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		String expTitle=data.FetchDataFromExcel("TestData", 8, 1);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actTitle, expTitle);
		System.out.println("Logout done");
		sa.assertAll();//mandatory
	}
	@AfterClass
	public void configAC()
	{
		driver.quit();
		System.out.println("Close Browser");
		}
	@AfterSuite
	public void configAS()
	{
		System.out.println("DB DIS-connect");
	}

}
