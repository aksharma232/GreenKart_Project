package greenKart_TestCases;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import dev.failsafe.Timeout;

import org.testng.Assert;

//@Listeners(resources_Utility.listeners.class)
public class gk_Order_Vegetable_Test extends gk_baseclass
{
	@Test(priority = 4)
	public void gk_searchVegetable_Order()
	{
		hp.search_Veg("Beet",1);
		
		hp.proceed_to_checkout().place_Order();
	}
	
	@Test(priority = 5)
	public void gk_add_one_vegetable_to_Cart()
	{
		hp.add_to_cart_vegetableList("Cauliflower - 1 Kg", 5);
		hp.vegetable_Into_Cart_Confirmation();
	}
	
	@Test(priority = 6)
	public void gk_add_Multiple_vegetable_to_Cart()
	{
		hp.add_to_cart_vegetableList("Cauliflower - 1 Kg", 5);
		hp.add_to_cart_vegetableList("Cucumber - 1 Kg",2);
		hp.add_to_cart_vegetableList("Beans - 1 Kg",1);
		hp.vegetable_Into_Cart_Confirmation();
	}
	
	@Test(priority = 7, groups = {"Smoke"})
	public void gk_Vegetable_Order()
	{
		hp.add_to_cart_vegetableList("Cauliflower - 1 Kg", 5);
		hp.add_to_cart_vegetableList("Cucumber - 1 Kg",2);
		hp.add_to_cart_vegetableList("Beans - 1 Kg",1);
		hp.proceed_to_checkout().place_Order();
	}
	
	@Test(priority = 8, groups = {"Smoke"})
	public void gk_Invalid_Code() throws InterruptedException
	{
		hp.search_Veg("Beet", 1);
		
		Assert.assertEquals(true,hp.proceed_to_checkout().apply_invalid_code("test"));
	}
}

