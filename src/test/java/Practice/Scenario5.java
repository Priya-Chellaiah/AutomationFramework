package Practice;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//WebDriverManager.edgedriver().setup();
		//WebDriver driver=new EdgeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.TAB,Keys.ENTER);
		//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys("jaisri");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		String mainid = driver.getWindowHandle();
		//System.out.println(mainid);
		Set<String> allId = driver.getWindowHandles();
		for (String id : allId) {
			if(!mainid.equals(id)) {
				driver.switchTo().window(id);
				driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("AIIMS");
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='AIIMS']")).click();
				}
		}
		driver.switchTo().window(mainid);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		String org = driver.findElement(By.xpath("//a[text()='AIIMS']")).getText();
		
		if(org.contains("AIIMS")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
			
		}
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img [@src='themes/softed/images/user.PNG'] ")).click();
		WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		Actions act =new Actions(driver);
		act.moveToElement(signout).click().perform();
	}

}
