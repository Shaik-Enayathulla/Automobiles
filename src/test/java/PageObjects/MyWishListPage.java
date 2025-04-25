package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWishListPage extends BasePage{

	public MyWishListPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='iPod Touch']")
	WebElement touch_iPod;
	
	public boolean isiPodTouch_add()
	{
		if(touch_iPod.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
