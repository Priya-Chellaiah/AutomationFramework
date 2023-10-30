package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePrintAllOrgname {

	public static void main(String[] args) {
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
				
				//check the 5th check box
				List<WebElement> orgs = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
				for (WebElement ele : orgs) {
					System.out.println(ele.getText());
					
				}
				

	}

}
