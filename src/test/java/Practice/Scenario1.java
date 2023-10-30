package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {
	@Test
		public void senario1Test() throws Throwable {
		//public static void main(String[] args) throws Throwable {
		//step1:Launching the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step2:loading the application
		driver.get("http://localhost:8888/");
		
		//step3:login to the application
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.TAB,Keys.ENTER);
		
		//step4:Navigate to the contacts link
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		
		//step5: click on create contact lookup icon
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		//step6:create contact
		driver.findElement(By.name("lastname")).sendKeys("jaisri");
		
		//step7:click on save button
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		//step8:validation
		String data = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();	
		if(data.contains("jaisri")) 
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
		System.out.println("Logged out successfully");
		}


}
