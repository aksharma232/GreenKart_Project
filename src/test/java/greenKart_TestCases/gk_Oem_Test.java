package greenKart_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class gk_Oem_Test extends gk_baseclass {

	@Test(priority = 1, groups= {"Smoke"})
	public void title_logo_Verification_Test()
	{
		Assert.assertEquals(hp.homePageTitle(),"GreenKart - veg and fruits kart");
		Assert.assertTrue(hp.homePage_Logo().isDisplayed());
		
	}

	@Test(priority = 2)
	public void click_On_Cart_Icon_Without_Adding_Veg()
	{
		Assert.assertEquals(true, hp.empty_Cart_Verification());
	}

	@Test(priority = 3, groups = {"Smoke"})
	public void increase_Decrease_Veg()
	{
		hp.increase_decrease_Veg();
	}
	
	@Test (priority = 4, groups = {"Smoke"})
	public void add_all_Items() throws InterruptedException
	{
	hp.add_allItemInCart();
	}
}
