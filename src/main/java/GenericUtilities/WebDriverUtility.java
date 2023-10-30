package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all the generic methods related to webdriver actions
 * @author HP
 */
public class WebDriverUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
		
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
		
	}
	
	/**
	 * This method will wait for the page to load 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method will wait until the element become visible in the DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait until the element to be clickable 
	 * @param driver
	 * @param ele
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement ele) {
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(ele));
				
	}
	/**
	 * This method will select the value using index
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will select the value using value
	 * @param element
	 * @param value
	 */
	
	public void handleDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will select the value using visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	public void mouseHoverAction(WebDriver driver,WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	/**
	 * This method will move cursor to the particular element and perform double click on that element 
	 * @param driver
	 * @param ele
	 */
	
	public void handleWebelements(WebDriver driver,WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).doubleClick(ele).perform();
	}
	/**
	 * This method will move the cursor to the particular element and perform right click on that element
	 * @param driver
	 * @param ele
	 * @param value
	 */
	
	public void handleWebelements(WebElement ele,WebDriver driver) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).contextClick(ele).perform();
	}
	
	
	
/**
 * This method will enter the user name and password and login to the page
 * @param ele1
 * @param ele2
 * @param ele3
 * @param driver
 * @param uname
 * @param pwd
 */
	public void login(WebElement username,WebElement password, WebElement login, WebDriver driver,String uname,String pwd) {
		Actions act=new Actions(driver);
		act.sendKeys(username,uname).sendKeys(password,pwd).click(login).perform();
	}
	/**
	 * This method will drag the particular element and drop it in the target element
	 * @param drag
	 * @param drop
	 * @param driver
	 */
	
	public void handleWebelements(WebElement drag,WebElement drop,WebDriver driver) {
		Actions act=new Actions(driver);
		act.clickAndHold(drag).release(drop).perform();
	}
	/**
	 * This method will drag the particular element and drop it in the target element
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	
	public void handleWebelements(WebDriver driver,WebElement drag,WebElement drop) {
		Actions act=new Actions(driver);
		act.dragAndDrop(drag,drop).perform();
	
	}
	/**
	 * This method will move the cursor to the specific area and click on the point.
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void handleWebelements(WebDriver driver) {
		Actions act=new Actions(driver);
		act.moveByOffset(10,10).click().perform();
	}
	
	/**
	 * This method will scroll the window down to the specified area
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("Window.ScrollBy(0,500);"," ");
		
	}
	/**
	 * This method will scroll the window up to the specified area
	 * @param x
	 * @param y
	 * @param driver
	 */
	public void scrollUp(int x,int y, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	
			js.executeScript("Window.ScrollBy(0,-500);"," ");
	}
		/**
		 * This method will handle frame by index
		 * @param driver
		 * @param index
		 */
		public void HandlingFrames(WebDriver driver, int index) {
			driver.switchTo().frame(index);
			
		}
		/**
		 *  This method will handle frame by name or Id
		 * @param driver
		 * @param nameorId
		 */
		public void HandlingFrames(WebDriver driver, String nameOrId) {
			driver.switchTo().frame(nameOrId);
			
		}
		/**
		 * This method will handle frame by web element
		 * @param driver
		 * @param ele
		 */
		
		public void HandlingFrames(WebDriver driver, WebElement ele) {
			driver.switchTo().frame(ele);
			
		}
		 /**
		  * This method will accept the alert popup
		  * @param driver
		  */
		public void acceptAlertPopup(WebDriver driver) {
			
			Alert alt= driver.switchTo().alert();
			alt.accept();
			
		}
		
		/**
		 * This method will dismiss the alert popup
		 * @param driver
		 */
	public void DismissAlertPopup(WebDriver driver) {
			
			Alert alt= driver.switchTo().alert();
			alt.dismiss();
			
		}
		
	/**
	 * This method will fetch the alert message and return it to the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		
		return driver.switchTo().alert().getText();
		
	}
	/**
	 * This method will switch to the required window based on the given title
	 * @param driver
	 * @param partialWinTitle
	 */
	
	
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		
		//step1:get all the window ids
		Set<String> allIds = driver.getWindowHandles();
		
		//step2:navigate through each window
		for (String id : allIds) {
			
			//step3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(id).getTitle();
			
			//step4:compare actual title with expected partial title

			if(actTitle.contains(partialWinTitle)) {
				break;
							
			}
		}
	}
	
	
	
	public String captureScreenshot(WebDriver driver,String screenshotName) throws Throwable {
		TakesScreenshot ss=(TakesScreenshot)driver;
		File src=ss.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshots\\"+screenshotName+".png");
		Files.copy(src, dest);
		//FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
		
		
		
	}
	}
