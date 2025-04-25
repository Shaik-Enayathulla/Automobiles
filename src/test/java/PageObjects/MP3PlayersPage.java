package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MP3PlayersPage extends BasePage{
	
	public MP3PlayersPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[contains(text(),'Touch')]")
	WebElement TouchPad;
	
	public void selectTouchPad()
	{
		TouchPad.click();
	}

}
