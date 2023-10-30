package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {//Rule1
	//Rule2: Declaration
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	//Rule3: Initialization
	public OrganizationInformationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Rule4: Utilization

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}

	
	//Business Library
	
	/**
	 * This method will capture the header text and return it to the caller
	 * @return
	 */
	public String getHeadertext() {
		return orgHeaderText.getText();
	}
	
	
	

}
