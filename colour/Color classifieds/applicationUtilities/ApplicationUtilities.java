package applicationUtilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ApplicationUtilities {
	WebDriver driver ;
	WebElement myElement;
	List<WebElement> myElements;
	
	public ApplicationUtilities(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement returnWebElement(String propType,String propValue) 
	{
		if(propType.trim().equals("id"))
			myElement = driver.findElement(By.id(propValue));
		else if(propType.trim().equals("name"))
			myElement = driver.findElement(By.name(propValue));
		else if(propType.trim().equals("className"))
			myElement = driver.findElement(By.className(propValue));
		else if(propType.trim().equals("cssSelector"))
			myElement = driver.findElement(By.cssSelector(propValue));
		else if(propType.trim().equals("linkText"))
			myElement = driver.findElement(By.linkText(propValue));
		else if(propType.trim().equals("partialLinkText"))
			myElement = driver.findElement(By.partialLinkText(propValue));
		else if(propType.trim().equals("tagName"))
			myElement = driver.findElement(By.tagName(propValue));
		else if(propType.trim().equals("xpath"))
			myElement = driver.findElement(By.xpath(propValue));
		//explicitWait(1);
		if(myElement.isEnabled())
			return myElement;
		else
			return null;
			
	}
	
	public void explicitWait(int seconds)
	{
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void selectAnElementFromDropDown(String propType,String propValue,int index)
	{
		new Select(returnWebElement(propType,propValue)).selectByIndex(index);
	}
	public void selectAnElementFromDropDown(String propType,String propValue,String text)
	{
		new Select(returnWebElement(propType,propValue)).selectByVisibleText(text);
	}
	public WebElement retrunWebElementFromColection(String propType,String propValue,String attributeType,String attributeValue)
	{
		myElements = returnWebElements(propType,propValue);
		for(int i=0;i<myElements.size();i++)
		{
			System.out.println(myElements.get(i).getAttribute(attributeType));
			if(myElements.get(i).getAttribute(attributeType).trim().equals(attributeValue))
			{
				myElement = myElements.get(i);
				break;
			}
		}
		return myElement;
	}
	public List<WebElement> returnWebElements(String propType,String propValue)
	{
		if(propType.trim().equals("id"))
			myElements = driver.findElements(By.id(propValue));
		else if(propType.trim().equals("name"))
			myElements = driver.findElements(By.name(propValue));
		else if(propType.trim().equals("className"))
			myElements = driver.findElements(By.className(propValue));
		else if(propType.trim().equals("cssSelector"))
			myElements = driver.findElements(By.cssSelector(propValue));
		else if(propType.trim().equals("linkText"))
			myElements = driver.findElements(By.linkText(propValue));
		else if(propType.trim().equals("partialLinkText"))
			myElements = driver.findElements(By.partialLinkText(propValue));
		else if(propType.trim().equals("tagName"))
			myElements = driver.findElements(By.tagName(propValue));
		else if(propType.trim().equals("xpath"))
			myElements = driver.findElements(By.xpath(propValue));
		return myElements;
	}
	
}



