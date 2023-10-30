package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {//Rule 1
	
	//Rule 2: Declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
			private WebElement createOrgLookupImage;
	
	//Rule3: Initialization
	public OrganizationsPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

	//Rule4:Utilization
	public WebElement getAddOrg() {
		return createOrgLookupImage;
	}
	
	//Business Library
	
	public void clickOnCreateOrganizationLookupImage() {
		createOrgLookupImage.click();
	}
	
	

}
