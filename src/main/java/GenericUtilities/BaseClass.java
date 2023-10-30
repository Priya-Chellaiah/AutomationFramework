package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public JavaUtilitiesEx jUtil=new JavaUtilitiesEx();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public WebDriver driver=null;
	
	//Used in Listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsconfig() {
		System.out.println("Db Connection Successful...");
	}
	
	
	//@Parameters("browser")	
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	 public void bcconfig(/*String BROWSER*/) throws Throwable {
	String BROWSER=pUtil.readDataFromPropertyFile("browser");
	String URL=pUtil.readDataFromPropertyFile("url");
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
	
	wUtil.maximizeWindow(driver);
	wUtil.waitForPageLoad(driver);
	//used in listeners
	sdriver=driver;
	
	driver.get(URL);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmconfig() throws Throwable{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		loginPage lp=new loginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("login successful..........");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amconfig() {
		
		HomePage hp= new HomePage(driver);
		hp.clickOnOrganizationsLink();
		System.out.println("logout successful..........");
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acconfig() {
		driver.quit();
		System.out.println("Browser closed.........");
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void asconfig() {
		System.out.println("Db Connection Closed.........");
	}
	
}
