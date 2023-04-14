package greenKart_TestCases;

import org.testng.annotations.Test;

import greenKart_Pages.gk_Top_Deal_Page;

public class gk_Top_Deal_Test extends gk_baseclass {
	
	gk_Top_Deal_Page gktd;
	
	@Test(priority = 9, groups = {"Smoke"})
	public void verify_Open_Topdeal()
	{
		gktd = hp.top_Deals();
		gktd.open_top_Deal();
	}
	
	@Test(priority = 10)
	public void verify_Search_Box_With_InvalidData()
	{
		gktd = hp.top_Deals();
		gktd.search_Top_Deal_With_Invalid_Veg("ajay");
	}
	@Test(priority = 11)
	public void verify_Search_Box_With_validData()
	{
		gktd = hp.top_Deals();
		gktd.search_Top_Deal_With_Valid_Veg("Tomato");
	}
		
	@Test(priority = 12)
	public void verify_Vegtable_Asending_Order()
	{
		gktd = hp.top_Deals();
		gktd.veg_Asending_Order();
	}
	
	@Test(priority = 13, enabled = true)
	public void verify_Vegtable_desending_Order()
	{
		gktd = hp.top_Deals();
		gktd.veg_descending_Order();
	}
	
	@Test(priority = 14)
	public void verify_Page_Menu()
	{
		gktd = hp.top_Deals();
		gktd.select_Page_Menu("20");
	
	}
	
	@Test(priority = 15, groups = {"Smoke"})
	public void verify_Last_Button_Functionality()
	{
		gktd = hp.top_Deals();
		gktd.verify_User_Click_On_LastButton();
	}
}

