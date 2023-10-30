package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2withDDT {

	public static void main(String[] args) throws Throwable {
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p=new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		//read data from excel-test data
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
		Workbook book= WorkbookFactory.create(fise);
		String ORGNAME= book.getSheet("contact").getRow(4).getCell(2).getStringCellValue();
		WebDriver driver=null;
		//Launch the browser-Runtime polymorphism-driver
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step2:load the application
		driver.get(URL);
		
		//step3:login to the application
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.TAB,Keys.ENTER);

		//step4:Navigate to the Organizations link
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
				
		//step5: click on create organization lookup icon
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
		//step6:create organization
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
		//step7:save
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
				
		Thread.sleep(2000);
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
				System.out.println("successfully logged out");
			}
	
	}


