package greenKart_Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class page_Utility 
{
	WebDriver d;
	
	public page_Utility(WebDriver d)
	{
		this.d = d;
	}

	public void waitForElementVisibility(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	
	public void waitForElementClickable(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public boolean element_Is_Displayed(WebElement e)
	{
		boolean element_Status = false;
		element_Status= e.isDisplayed();
		return element_Status;
	}

	public void select_Value(WebElement e, String value)
	{
		Select page_Menu_Select = new Select(e);
		page_Menu_Select.selectByValue(value);
		//selectByIndex(value);
		
	}



}
