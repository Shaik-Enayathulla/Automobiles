package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TouchPadDevicePage extends BasePage {
	public TouchPadDevicePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//i[@class='fa fa-heart']")
	WebElement TouchPadAddWishList_btn;
	
	@FindBy(xpath="//div[@id='product-product']/div")
	WebElement Actual_Diplayed_msg;
	
	public void AddTouchTo_WishList()
	{
		TouchPadAddWishList_btn.click();
	}
	
	public String Actual_Msg_from_WebPage()
	{
		return Actual_Diplayed_msg.getText();
	}
	

}
