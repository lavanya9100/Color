package pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import applicationUtilities.ApplicationUtilities;
import applicationUtilities.Screenshot;
import generalUtilities.ReadProperties;
import generalUtilities.ReadXl;

public class ColorclassifiedPage {
	WebDriver driver;
	ApplicationUtilities utils;
	ReadProperties prop;
	ReadXl myXl;
	//Screenshot screen;
	public ColorclassifiedPage(WebDriver driver)
	{
      this.driver=driver;
      this.utils=new ApplicationUtilities(driver);
      this.prop=new ReadProperties("E:\\Lavanya\\colour\\TestData\\colorClassified.Properties");
     //this.myXl=new ReadXl()
	 // this.screen= new Screenshot("E://selenium.png");
	}
	public void launch() throws InterruptedException
	{
		
	    driver.get(prop.readData("Url"));
	    driver.manage().window().maximize();
	  //  screen.grabscreenshot("E://selenium1.png");
	    Thread.sleep(5000);
	}
	public void login() throws InterruptedException
	{ //click on login link
		utils.returnWebElement("xpath","//a[contains(@href,'member_login.php')][text()='Log in']").click();
		Thread.sleep(5000);
		utils.returnWebElement("id","username").sendKeys(prop.readData("UserName"));
		utils.returnWebElement("name","password").sendKeys(prop.readData("PassWord"));
		utils.returnWebElement("name","submit").click();
		Thread.sleep(6000);
		//screen.grabscreenshot("E://selenium2.png");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      try{
	         FileUtils.copyFile(src,new File("Screenshort"));
	        }catch(IOException e){
	           e.printStackTrace();
	          }


	//Notify new ad function code
	  
		utils.returnWebElement("xpath","//*[contains(@href,'member_notify.php')]").click();
		File src2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      try{
	         FileUtils.copyFile(src,new File("Screenshort2"));
	        }catch(IOException e){
	           e.printStackTrace();
	          }

		
		List<WebElement> chkbox = utils.returnWebElements("xpath", "//input[contains(@name,'catid')]");
		String catid_str = "2,3,4,5";
		String[] str_array = catid_str.split(","); 
		int[] cat_ids = new int[str_array.length]; 
		for (int i = 0; i < cat_ids.length; i++)
		{
			cat_ids[i] = Integer.parseInt(str_array[i]); 
		}
		
		for(int i=0;i<cat_ids.length;i++)
		{	
			if(chkbox.get(cat_ids[i]).isSelected()==false)
			{
			chkbox.get(cat_ids[i]).click();
			}
			else
			{
				System.out.println(cat_ids[i]+ "already selected");
			}
		}
		 JavascriptExecutor j = (JavascriptExecutor)driver;
		 j.executeScript("window.scrollBy(0,600)");
		utils.returnWebElement("name", "submit").click();	
		utils.returnWebElement("xpath","//*[contains(@href,'member_notify.php')]").click();
		//logout function
		utils.returnWebElement("xpath","//*[contains(@href,'member_login.php?logout=1')]").click();
}
	 public void logOut()
	   {
		
		utils.returnWebElement("xpath", "//*[@id='login']/a").click();
	   }



}
	
  /* //another account delete function code
	public void login2() throws InterruptedException{
		utils.returnWebElement("xpath","//a[contains(@href,'member_login.php')][text()='Log in']").click();
		Thread.sleep(5000);
		utils.returnWebElement("id","username").sendKeys(prop.readData("UserName2"));
		utils.returnWebElement("name","password").sendKeys(prop.readData("PassWord2"));
		utils.returnWebElement("name","submit").click();
		Thread.sleep(6000);
		utils.returnWebElement("xpath","//a[contains(@href,'member_change.php')]").click();
		utils.returnWebElement("xpath","//u[contains(text(),'Delete my ')]").click();
		utils.returnWebElement("xpath","//u[contains(text(),'Yes, I do')]").click();
		//utils.returnWebElement
   }

	public void TopAds() throws InterruptedException{
		utils.returnWebElement("xpath","//a[contains(@href,'member_login.php')][text()='Log in']").click();
		Thread.sleep(5000);
		utils.returnWebElement("id","username").sendKeys(prop.readData("UserName"));
		utils.returnWebElement("name","password").sendKeys(prop.readData("PassWord"));
		utils.returnWebElement("name","submit").click();
		Thread.sleep(6000);
		utils.returnWebElement("xpath","//a[contains(@href,'mostviewed.php')]").click();
		Thread.sleep(6000);
		utils.returnWebElement("xpath","//a[contains(@href,'detail.php?id=7')]").click();
	}
		
		
	}*/


