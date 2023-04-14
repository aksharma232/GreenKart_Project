package greenKart_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class gk_place_orderPage extends page_Utility
{
WebDriver d;
	
	public gk_place_orderPage(WebDriver d)
	{
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath="//button[normalize-space()='Place Order']")
	WebElement placeOrder;
	
	@FindBy(xpath = "//input[@placeholder='Enter promo code']")
	WebElement apply_Code_Text;
	
	@FindBy(xpath = "//button[normalize-space()='Apply']")
	WebElement apply_Code;
	
	@FindBy(xpath = "//span[@class='promoInfo']")
	WebElement invliad_Code_Error;
	
	public void place_Order() 
	{
		waitForElementVisibility(placeOrder);
		placeOrder.click();
	}
	
	public boolean apply_invalid_code(String code) throws InterruptedException
	{
		Thread.sleep(2000);
		apply_Code_Text.sendKeys(code);
		apply_Code.click();
		Thread.sleep(5000);
		element_Is_Displayed(invliad_Code_Error);
		return element_Is_Displayed(invliad_Code_Error);
		
	}
	
	
	
	
	
	
	
	
}
