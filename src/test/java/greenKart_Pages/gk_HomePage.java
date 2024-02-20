package greenKart_Pages;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.*;

public class gk_HomePage extends page_Utility
{
	WebDriver d;
	
	public gk_HomePage(WebDriver d)
	{
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath = "//div[@class='brand greenLogo']")
	WebElement greeenKartLogo;
	
	@FindBy(xpath = "//h4[@class=\"product-name\"]")
	List <WebElement> vegetable_List;	
	
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='+'])[1]")
	WebElement increase_Veg_Button;
	
	@FindBy(xpath = "(//a[@href='#'][contains(text(),'–')])[1]")
	WebElement decrease_Veg_Button;	
	
	@FindBy(xpath="//img[@alt='Cart']")
	WebElement cartButton;
	
	@FindBy(xpath="//button[normalize-space()='PROCEED TO CHECKOUT']")
	WebElement proceed_to_Checkout;
	
	@FindBy(xpath="//input[@placeholder='Search for Vegetables and Fruits']")
	WebElement searchVegetable;
	
	@FindBy(xpath = "//button[normalize-space()='ADD TO CART']")
	WebElement add_To_Cart;
	
	@FindBy(xpath = "//a[normalize-space()='Top Deals']")
	WebElement top_Deals;
	
	@FindBy(xpath = "//img[@alt=\"empty-cart\"]")
	WebElement empty_Cart;
	
	public String homePageTitle()
	{
		return d.getTitle();		
	}
	
	public WebElement homePage_Logo()
	{
		return greeenKartLogo;
	}
	
	public void add_to_cart_vegetableList(String vegName,int kg)
	{
		for(int i = 0; i< vegetable_List.size();i++)
		{
			String vegtable = vegetable_List.get(i).getText();
			if(vegtable.equalsIgnoreCase(vegName))
			{	
				if(kg>1)
				{	
				for(int j=1;j<kg;j++)
				{
					d.findElement(By.xpath("//h4[normalize-space()='"+vegtable+"']/following::a[2]")).click();
				}
				}
				d.findElement(By.xpath("//h4[normalize-space()='"+vegtable+"']/following::button[1]")).click();
			}
			
		}
	}
	
	public void vegetable_Into_Cart_Confirmation()
	{
		cartButton.click();
		assertTrue(element_Is_Displayed(proceed_to_Checkout));
	}
	public gk_place_orderPage proceed_to_checkout()
	{
		cartButton.click();
		proceed_to_Checkout.click();
		gk_place_orderPage op = new gk_place_orderPage(d);
		//op.place_Order();
		return op;
	}
	
	public void search_Veg(String veg, int kg)
	{
		searchVegetable.sendKeys(veg);
		if(kg>1)
		{
			for(int i=1;i<kg;i++)
			{
				increase_Veg_Button.click();
			}
		}
		waitForElementClickable(add_To_Cart);
		add_To_Cart.click();
	}
	
	

	public gk_Top_Deal_Page top_Deals()
	{
		top_Deals.click();
		gk_Top_Deal_Page tdp = new gk_Top_Deal_Page(d);
		String pw = d.getWindowHandle();
		Set<String> windows = d.getWindowHandles();
		Iterator<String> i = windows.iterator();
		while(i.hasNext())
		{
			String cw = i.next();
			if(!pw.equals(cw))
			{
			d.switchTo().window(cw);
		}
	}
		return tdp;

	}

	public boolean empty_Cart_Verification()
{
	cartButton.click();
	return element_Is_Displayed(empty_Cart);
}

	public void increase_decrease_Veg()
	{
		increase_Veg_Button.click();
		
		decrease_Veg_Button.click();
	}








}
