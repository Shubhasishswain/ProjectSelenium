package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactUsPage;
import pompages.CoreJavaForSelenium;
import pompages.CoreJavaVideoPage;
import pompages.HomePage;
import pompages.SeleniumTrainingPage;
import pompages.SkillraryDemoAppPage;
import pompages.TestingPage;

public class BaseClass {
	
	protected PropertiesFilesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePage home;
	protected SkillraryDemoAppPage skillraryDemo;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected CoreJavaForSelenium coreJava;
	protected CoreJavaVideoPage javaVideo;
	protected ContactUsPage contact;
	protected long time;
	
	
	
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	public void classConfiguration()
	{
		 property=new PropertiesFilesUtility();
		excel=new ExcelUtility();
		web=new WebDriverUtility();
		
		property.PropertyFileIntialization(IConstatntPath.PROPERTIES_FILE_PATH);
		excel.excelIntialization(IConstatntPath.EXCEL_FILE_PATH);
	}
	@BeforeMethod
	public void methodConfiguration()
	{
	    time=Long.parseLong(property.fetchproperty("timeouts"));
		driver= web.openApplication(property.fetchproperty("browser"),property.fetchproperty("url"),time);
		
		home=new HomePage(driver);
		
		Assert.assertTrue(home.getlogo().isDisplayed());
		
		skillraryDemo=new SkillraryDemoAppPage(driver);
		selenium=new SeleniumTrainingPage(driver);
		testing=new TestingPage(driver);
		coreJava=new CoreJavaForSelenium(driver);
		javaVideo=new CoreJavaVideoPage(driver);
		contact=new ContactUsPage(driver);
	}
	
	@AfterMethod
	public void methodTearDoen()
	{
		web.quitBrowser();
	}
	@AfterClass
	public void classTearDown()
	{
		excel.closeExcel();
	}
	//@AfterTest
	//@AfterSuite

}
