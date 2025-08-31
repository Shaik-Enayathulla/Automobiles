package PageObjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
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
	
	@FindBy(xpath="//div[3]//div[3]//div[1]")
	WebElement BottmTabNavigator_btn;
	
	@FindBy(xpath="//div[@class='swiper-slide text-center']//img[@alt='Dell']")
	WebElement Dell_logo;
	
	@FindBy(xpath="//button[contains(@class,'btn-link') and @data-toggle='dropdown']")
	WebElement CurrencyDropDown_btn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li[contains(.,'€Euro')]")
	WebElement Euro_currency_opt;
	
	@FindBy(xpath="//p[@class='price']/span[contains(.,'Tax:392.30€')]")
	WebElement Actual_currency;
	
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
	
	public void nextButtomTabNavigator_btn()
	{
		Actions act = new Actions(driver);
		act.moveToElement(BottmTabNavigator_btn);
		BottmTabNavigator_btn.click();
	}
	
	public WebElement Dell_logo_check()
	{
		return Dell_logo;
	}
	
	public void ScreenShort_Dell_Logo() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		String time_stamp = new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss").format(new Date());
		String name = "Dell_Logo_"+time_stamp+".png";
		File snap = Dell_logo.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(snap, new File(System.getProperty("user.dir")+"/ScreenShots/"+name));
	}
	
	public void SelectEuroCurrency()
	{
		CurrencyDropDown_btn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Euro_currency_opt)).click();
		
	}
	
	public String Actual_Currency()
	{
		return Actual_currency.getText();
	}
}
