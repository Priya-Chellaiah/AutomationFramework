package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2 {

	public static void main(String[] args) throws Throwable {
		//step1:Launching the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//step2:loading the application
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//step3:login to the application
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.TAB,Keys.ENTER);
		//step4:Navigate to the Organizations link
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		
		//step5: click on create organization lookup icon
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step6:create organization
		driver.findElement(By.name("accountname")).sendKeys("IIT");
		
		//step7:save
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		
		//step8: validation
		String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(org.contains("IIT")) 
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
