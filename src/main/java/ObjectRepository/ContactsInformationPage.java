package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInformationPage {//Rule 1:class name same as web page name


	//Rule 2: declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	
	//Rule3: Initialization
	public ContactsInformationPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

	//Rule4:Utilization

	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}

	//Business Library	
	/**
	 * This method will capture the contact name and return it to the caller
	 * @return
	 */
	
	public String getHeaderText() {
		return contactHeaderText.getText();
	}
	
}
