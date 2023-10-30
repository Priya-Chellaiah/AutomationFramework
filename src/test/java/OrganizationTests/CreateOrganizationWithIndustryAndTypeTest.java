package OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
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

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass {

	//public static void main(String[] args) 
	@Test
	public void createorgWithIndustryandTypeTest()throws Throwable {
		
				String ORGNAME  = eUtil.readDatafromEcxel("Contact", 7, 2)+jUtil.createRandomnum();
				String INDUSTRY = eUtil.readDatafromEcxel("Contact", 7, 3);
				String TYPE = eUtil.readDatafromEcxel("Contact", 7, 4);
				
				
				//step6: Click on Organization
				
				HomePage hp= new HomePage(driver);
				hp.clickOnOrganizationsLink();
				
				//step7:click on organization lookup image
				OrganizationsPage op=new OrganizationsPage(driver);
				op.clickOnCreateOrganizationLookupImage();
				
				//step8:create new organization with industry and type
				CreatingNewOrganization cnop=new CreatingNewOrganization(driver);
				cnop.createNewOrganization(ORGNAME, INDUSTRY, TYPE);	
				
				//step9: validate for organization 
				OrganizationInformationPage oip=new OrganizationInformationPage(driver);
				String orgHeader=oip.getHeadertext();
				Assert.assertTrue(orgHeader.contains(ORGNAME));
//				if(orgHeader.contains(ORGNAME)) {
//					System.out.println(orgHeader);
//					System.out.println("Organization with Industry and type Created ");
//				}
//				else {
//					System.out.println("Fail");
//				}
				
				
	}

}
