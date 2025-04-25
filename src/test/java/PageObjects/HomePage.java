package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement drpMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement optRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement optLogin;
	
	@FindBy(xpath="//a[text()='MP3 Players']")
	WebElement DropDown_MP3Player;
	
	@FindBy(xpath="//a[@class='see-all' and text()='Show AllMP3 Players']")
	WebElement Mp3Players;
	
	public void clickdrpMyaccount()
	{
		drpMyaccount.click();
	}
	
	public void clickRegister()
	{
		optRegister.click();
	}
	
	public void clickLogin()
	{
		optLogin.click();
	}//input[@value='Login']
	
	public void clickMp3PlayerDropDown()
	{
		DropDown_MP3Player.click();
	}
	
	public void NavigateToMp3playersShop()
	{
		Mp3Players.click();
	}
}
