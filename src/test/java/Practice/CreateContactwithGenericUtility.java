package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtilitiesEx;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactwithGenericUtility {

	public static void main(String[] args) throws Throwable {
				ExcelFileUtility eUtil=new ExcelFileUtility();
				WebDriverUtility wUtil=new WebDriverUtility();
				PropertyFileUtility pUtil=new PropertyFileUtility();
				WebDriver driver=null;
				
				//step2:read the required data
				String BROWSER = pUtil.readDataFromPropertyFile("browser");
				String URL = pUtil.readDataFromPropertyFile("url");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");
				String LASTNAME = eUtil.readDatafromEcxel("Contact",1,2);
				
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
				
				//step5:login to application
				//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				//driver.findElement(By.id("submitButton")).click();
				
				loginPage lp=new loginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				//lp.getUsernameEdt().sendKeys(USERNAME);
				//lp.getPasswordEdt().sendKeys(PASSWORD);
				//lp.getLoginBtn().click();
				
				//step6:Navigate to the contacts link
				driver.findElement(By.xpath("//a[.='Contacts']")).click();
				
				//step7: click on create contact lookup icon
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

				//step8:create contact with mandatory fields
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				//step9:click on save button
				driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
				
				//step10:validation
				String data = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();	
				if(data.contains(LASTNAME)) 
				{
					System.out.println("Pass");
				}
				else 
				{
					System.out.println("Fail");
				}
				
				//step11:logout
				Thread.sleep(1000);
				driver.findElement(By.xpath("//img [@src='themes/softed/images/user.PNG'] ")).click();
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				System.out.println("Logged out successfully");
				
				
				

	}

}
