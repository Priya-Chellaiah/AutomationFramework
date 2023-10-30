package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5withDDT {

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
		String LASTNAME= book.getSheet("contact").getRow(13).getCell(2).getStringCellValue();
		String ORGNAME = book.getSheet("contact").getRow(13).getCell(3).getStringCellValue();
		//String TYPE = book.getSheet("contact").getRow(10).getCell(4).getStringCellValue();
		
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//step3:login to the application
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.TAB,Keys.ENTER);
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		String mainid = driver.getWindowHandle();
		//System.out.println(mainid);
		Set<String> allId = driver.getWindowHandles();
		for (String id : allId) {
			if(!mainid.equals(id)) {
				driver.switchTo().window(id);
				driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(ORGNAME);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[@id='1']")).click();
				}
		}
		driver.switchTo().window(mainid);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		String data = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();	
		if(data.contains(LASTNAME)) 
		{
			System.out.println("Pass");
		}
		else 
		{
			System.out.println("Fail");
		}
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img [@src='themes/softed/images/user.PNG'] ")).click();
		WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		Actions act =new Actions(driver);
		act.moveToElement(signout).click().perform();
		System.out.println("logged out successfully");
		
		
		
	}

}
