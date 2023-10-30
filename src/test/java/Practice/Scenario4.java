package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.TAB,Keys.ENTER);
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("abchjghu");
		WebElement ele = driver.findElement(By.xpath("//select[@name='industry']"));
		Select sel=new Select(ele);
		sel.selectByValue("Energy");
		WebElement path = driver.findElement(By.name("accounttype"));
		Select sele=new Select(path);
		sele.selectByValue("Customer");
		
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		String type = driver.findElement(By.xpath("//span[@id='dtlview_Type']")).getText();
		if(type.contains("Customer")) 
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
	}
	}


