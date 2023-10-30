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
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationwithGenericUtility {

	private static final String ORGNAME = null;

	public static void main(String[] args) throws Throwable {
		//step1: create the required objects
		JavaUtilitiesEx jUtil=new JavaUtilitiesEx();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		WebDriver driver=null;
		
		//step2:read the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME=eUtil.readDatafromEcxel("Contact", 4, 2)+jUtil.createRandomnum();
		
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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step6: navigate to organizations link
		
        driver.findElement(By.xpath("//a[.='Organizations']")).click();
		
		//step5: click on create organization lookup icon
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step6:create organization
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//step7:save
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		
		//step8: validation
		String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(org.contains(ORGNAME)) 
		{
			System.out.println("Pass");
		}
		else 
		{
			System.out.println("Fail");
		}
		
		//step9:logout
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//img [@src='themes/softed/images/user.PNG'] ")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}

