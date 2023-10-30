package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreatingNewContact extends WebDriverUtility {//Rule1:class name same as web page name


	//Rule 2: declaration
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "(//img[@alt='Select'])[1]")
	private WebElement orgLookup;
	
	@FindBy(name = "search_text")
	private WebElement orgSearchEdt;
	
	@FindBy(name = "search")
	private WebElement orgSearchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Rule3: Initialization
	public CreatingNewContact(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

	//Rule4:Utilization
	
	public WebElement getLastName() {
		return lastNameEdt;
	}

	public WebElement getOrgLookup() {
		return orgLookup;
	}

	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	//Business Library
	
	/**
	 * This method will create contact with mandatory fields
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create contact with organization name
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void createNewContact(WebDriver driver,String LASTNAME, String ORGNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		orgLookup.click();
		switchToWindow(driver, "Accounts");
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();		
		
		
	}
}
