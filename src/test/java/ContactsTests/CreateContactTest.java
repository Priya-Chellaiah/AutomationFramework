package ContactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtilitiesEx;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.ContactsInformationPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreatingNewContact;
import ObjectRepository.HomePage;
import ObjectRepository.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(GenericUtilities.ListenersImplementationClass.class) //to analyse the script and find where and what gone failed 
public class CreateContactTest extends BaseClass {

	//public static void main(String[] args) throws Throwable 
	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createContactTest() throws Throwable
	{
				String LASTNAME = eUtil.readDatafromEcxel("Contact",1,2);
								
			
				
				//step6:click on contacts link
				
				HomePage hp=new HomePage(driver);
				hp.clickOnContactsLink();
				Reporter.log("Clicked on contacts link...");// to analyse the script easily we use logs
				
				//step7:click on create contact look up icon
				ContactsPage cp=new ContactsPage(driver);
				cp.createContactLookupImage();
				Reporter.log("Clicked on contacts look up image...");
				
				//step8:create contact with mandatory fields
				CreatingNewContact cncp=new CreatingNewContact(driver);
				cncp.createNewContact(LASTNAME);
				Reporter.log("Contact created successfully...");
				
				//step9:validate for contact
				
				ContactsInformationPage cip= new ContactsInformationPage(driver);
				String contactHeader=cip.getHeaderText();
				Reporter.log("Header Captured...");
				
				//Thread.sleep(1000);
				Assert.assertTrue(contactHeader.contains(LASTNAME));
				System.out.println(contactHeader);
	}
//				if(contactHeader.contains(LASTNAME)) {
//					System.out.println(contactHeader);
//					System.out.println("Pass");
//				}
//				else {
//					System.out.println("Fail");
//				}
	
				public void demo() {
					System.out.println("Sample demo class");
				}

	}
