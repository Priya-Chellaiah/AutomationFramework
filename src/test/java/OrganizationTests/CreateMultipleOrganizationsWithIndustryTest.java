package OrganizationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtilitiesEx;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.CreatingNewOrganization;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationInformationPage;
import ObjectRepository.OrganizationsPage;
import ObjectRepository.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateMultipleOrganizationsWithIndustryTest {
	ExcelFileUtility eUtil=new ExcelFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	JavaUtilitiesEx jUtil=new JavaUtilitiesEx();
	
	@Test(dataProvider="getData")
	public void CreateMultipleOrgWithIndustry(String ORG, String INDUSTRYNAME) throws Throwable {
		WebDriver driver=null;
		
		//step2:read the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		//String LASTNAME = eUtil.readDatafromEcxel("Contact",1,2);
		String ORGNAME=ORG+jUtil.createRandomnum();
		
		//step3:launch the browser
		if(BROWSER.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+"  browser launched");
			}
		else if(BROWSER.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+"  browser launched");
			}
		else if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+"   browser launched");
			}
		else {
			System.out.println("Invalid browser name");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		//step4:load the URL
		
		driver.get(URL);
		
		//step5: Login to the application
		
		loginPage lp=new loginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//step6: Click on Organization
		
		HomePage hp= new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		//step7:click on organization lookup image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrganizationLookupImage();
		
		//step8:create new organization with mandatory fields
		CreatingNewOrganization cnop=new CreatingNewOrganization(driver);
		//cnop.createNewOrganization(ORGNAME);
		cnop.createNewOrganization(ORGNAME, INDUSTRYNAME);
		wUtil.captureScreenshot(driver, ORGNAME);
		
		//step9: validate for organization 
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String orgHeader=oip.getHeadertext();
		if(orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader);
			System.out.println("Organization Created");
		}
		else {
			System.out.println("Fail");
		}
		
		//step10: logout
		
		hp.logOutOfApp(driver);
		
	}
	
	@DataProvider 
	public Object[][] getData() throws IOException{
		return eUtil.readMultipleData("MultipleOrganizations");
	}

}
