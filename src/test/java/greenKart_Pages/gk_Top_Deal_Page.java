package greenKart_Pages;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class gk_Top_Deal_Page extends page_Utility
{
	WebDriver d;
	public gk_Top_Deal_Page(WebDriver d)
	{
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath = "//span[@class='redLogo']")
	WebElement top_Deal_Page_Gk_Logo;
	
	@FindBy(xpath = "//span[@class='sort-icon sort-descending']")
	WebElement sort_Veg_AsendingOrder;
	
	@FindBy(xpath ="//span[@class='sort-icon sort-ascending']")
	WebElement sort_Veg_DescendingOrder;
	
	@FindBy(id = "search-field")
	WebElement top_Deal_Search;
	
	@FindBy(xpath = "//td[contains(text(),'No data')]")
	WebElement after_Search_NoData;
	
	@FindBy(xpath= "//table//tr[1]/td[1]")
	WebElement after_Search_With_ValidVeg;
	
	@FindBy(xpath = "//select[@id='page-menu']")
	WebElement page_Menu;
	
	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> default_price_list; 
	
	@FindBy(xpath = "//tbody/tr")
	List<WebElement> all_Vegtable_List_After_Page_Size;
	
	@FindBy(xpath = "//a[@aria-label='Last']")
	WebElement last_Button_Enable;	
	
	@FindBy(xpath = "//li[@class='disabled']//a[@aria-disabled=\"true\" and @aria-label=\"Next\"]")
	WebElement next_Button_Disabled;
	
	public void open_top_Deal()
	{
		assertTrue(element_Is_Displayed(top_Deal_Page_Gk_Logo));
	}
	
	public void search_Top_Deal_With_Invalid_Veg(String veg)
	{
		top_Deal_Search.sendKeys(veg);
		Assert.assertTrue(element_Is_Displayed(after_Search_NoData));
	}
	
	public void search_Top_Deal_With_Valid_Veg(String veg)
	{
		top_Deal_Search.sendKeys(veg);
		Assert.assertTrue(element_Is_Displayed(after_Search_With_ValidVeg));
		
	}
	
	public void veg_Asending_Order()
	{
		sort_Veg_AsendingOrder.click();
		ArrayList<String> actual_price = new ArrayList<String>();
		ArrayList<String> sorted_price = new ArrayList<String>();
		
		//Object String;
		for(int i=0; i < default_price_list.size(); i++)
		//for(WebElement price : default_price_list)
		{
			actual_price.add(default_price_list.get(i).getText());
			
		}
		
		for(String price: actual_price)
		{
			sorted_price.add(price);
			
		}
			System.out.println("Actual value which displyed initally ="+actual_price);
			Collections.sort(actual_price);
			Collections.sort(sorted_price);
			System.out.println("Values in ascending order"+sorted_price);
			Assert.assertEquals(actual_price, sorted_price);
			
	}
	
	public void veg_descending_Order()
	{
		sort_Veg_AsendingOrder.click();
		sort_Veg_DescendingOrder.click();
		ArrayList<String> actual_price = new ArrayList<String>();
		ArrayList<String> sorted_price = new ArrayList<String>();
		
		for(WebElement price : default_price_list)
			actual_price.add(price.getText());
		
		for(String price : actual_price)
			sorted_price.add(price);
	
		System.out.println("Actual Value = "+actual_price);
		Collections.sort(sorted_price);
		Collections.reverse(sorted_price);		
		System.out.println("Sorted Value = "+sorted_price);
		
	
	
	}
	
	public void select_Page_Menu(String page_Size_Value)
	{
		int a =0 ;
		//System.out.println(a);
		try
		{
			if(page_Size_Value.equalsIgnoreCase("5"))
			{
				select_Value(page_Menu, page_Size_Value);
				a = all_Vegtable_List_After_Page_Size.size();
				System.out.println(a);
				assertTrue(a>=1 && a<=5);
			}
			else if(page_Size_Value.equalsIgnoreCase("10"))
			{
				select_Value(page_Menu, page_Size_Value);
				a = all_Vegtable_List_After_Page_Size.size();
				System.out.println(a);
				assertTrue(a>=1 && a<=10);
			}
			else if(page_Size_Value.equalsIgnoreCase("20"))
			{
				select_Value(page_Menu, page_Size_Value);
				a = all_Vegtable_List_After_Page_Size.size();
				System.out.println(a);
				assertTrue(a>=1 && a<=20);
			}
			else
			{
				System.out.println("Invalid Data");
				assertTrue(false);
			}
		}
		catch(Exception e)
		{
			System.out.println("Invalid Data");
		}
		//int total_Veg = all_Vegtable_List_After_Page_Size.size()
				
	}
	public void verify_User_Click_On_LastButton()
	{
		last_Button_Enable.click();
		Assert.assertTrue(element_Is_Displayed(next_Button_Disabled));
	}
}
