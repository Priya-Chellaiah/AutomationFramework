package Practice;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupCurrentDate {

	public static void main(String[] args) throws Throwable {
		
		//launch the driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//navigate to the application
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//handle popup using actions class
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		//navigate to departure element
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		//fetching the system date using date class
		
		Date d=new Date();
		//SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
		/*SimpleDateFormat formatter=new SimpleDateFormat("EEE MMM dd yyyy");
		String date = formatter.format(d);
		System.out.println(date);*/
		
		String[] dArray = d.toString().split(" ");
		String currentDate = dArray[0]+" "+dArray[1]+" "+dArray[2]+" "+dArray[5];
		
		// accessing the required date using dynamic xpath 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();
		//driver.findElement(By.xpath("//div[@aria-label='"+date+"']")).click();
		

	}

}
