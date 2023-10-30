package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreatingNewOrganization extends WebDriverUtility{//Rule 1

	
	//Rule 2: declaration
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name  ="industry")
	private WebElement industrydropdown;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typedropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
		
	//Rule3: Initialization
	public CreatingNewOrganization(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

	//Rule4:Utilization
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}


	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}


	public WebElement getTypedropdown() {
		return typedropdown;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Business Library
	
	public void createNewOrganization(String ORGNAME) {
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	
	}
	public void createNewOrganization(String ORGNAME, String INDUSTRY) {
		
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(INDUSTRY, industrydropdown);
		saveBtn.click();
	}
	
public void createNewOrganization(String ORGNAME, String INDUSTRY,String TYPE) {
		
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(INDUSTRY, industrydropdown);
		handleDropDown(TYPE,typedropdown);
		saveBtn.click();
	}
	
	
}
