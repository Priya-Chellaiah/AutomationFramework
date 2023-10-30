package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupFutureDate {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		for(;;)//infinite loop 
		{
			
				try//if not visible-exception, if visible -click and break
				{
					driver.findElement(By.xpath("//div[@aria-label='Fri Jan 05 2024']")).click();//no such element exception
					break;
					
				}
				catch(Exception e)//click on next month arrow
				{
					driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
					Thread.sleep(1000);
				}
		}
	
	
	}
	

}
