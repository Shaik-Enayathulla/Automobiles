package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Validation extends BasePage{
	
	public Validation(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement vlidtext;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnlogout;
	
	public boolean ValitationofAccount()
	{
		if(vlidtext.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		btnlogout.click();
	}

}
