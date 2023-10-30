package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4withDDT {

	public static void main(String[] args) throws Throwable, IOException {
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
		String ORGNAME= book.getSheet("contact").getRow(10).getCell(2).getStringCellValue();
		String INDUSTRY = book.getSheet("contact").getRow(10).getCell(3).getStringCellValue();
		String TYPE = book.getSheet("contact").getRow(10).getCell(4).getStringCellValue();
		
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//step2:load the application
		driver.get(URL);
		
		//step3:login to the application
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.TAB,Keys.ENTER);
	
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		WebElement ele = driver.findElement(By.xpath("//select[@name='industry']"));
		Select sel=new Select(ele);
		sel.selectByValue(INDUSTRY);
		WebElement path = driver.findElement(By.name("accounttype"));
		Select sele=new Select(path);
		sele.selectByValue(TYPE);
		
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		String type = driver.findElement(By.xpath("//span[@id='dtlview_Type']")).getText();
		if(type.contains(TYPE)) 
		{
			System.out.println("Pass");
		}
		else 
		{
			System.out.println("Fail");
		}
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img [@src='themes/softed/images/user.PNG'] ")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("logout successful");

	}

}
