package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {//Rule1
	//Ruke2: Declaration of webelements
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactLookupImage;
	
	//Ruke3:Initialization
	public ContactsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	//Rule4: Utilization
	public WebElement getAddContact() {
		return createContactLookupImage;
	}
	
	//Business library
	/**
	 * This method will click on create contact look up image
	 */
	public void createContactLookupImage() {
		createContactLookupImage.click();
	}

}
