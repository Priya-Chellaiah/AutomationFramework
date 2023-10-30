package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {//Rule 1
	
	//Rule 2: Declaration- dropdowns,frames,windows,popups,textfields
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrationImage;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	//Rule3: Initialization
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	//Rule3: Utilization
	
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getAdministrationImage() {
		return administrationImage;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	//Business Library
	
	/**
	 *  This method will click on contacts link
	 */
	public void clickOnContactsLink() {
		contactsLink.click();
	}
	/**
	 * This method will click on organizations link
	 */
	public void clickOnOrganizationsLink() {
		organizationsLink.click();
	}
	
	/**
	 * This method will logout of the application
	 * @param driver
	 * @throws Throwable
	 */
	public void logOutOfApp(WebDriver driver) throws Throwable {
		
		mouseHoverAction(driver, administrationImage);
		Thread.sleep(1000);
		signOut.click();
	
	}
	
	}
	
	


