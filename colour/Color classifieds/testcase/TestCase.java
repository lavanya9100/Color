package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;
import generalUtilities.ReadXl;
import pageObjects.ColorclassifiedPage;

public class TestCase {
     WebDriver driver=new FirefoxDriver();
     ApplicationUtilities utils=new ApplicationUtilities(driver) ;
 	ReadProperties prop=new ReadProperties("E:\\Lavanya\\colour\\TestData\\colorClassified.Properties") ;
 	//ReadXl myXl=new ReadXl();
 	ColorclassifiedPage po=new ColorclassifiedPage(driver);
@BeforeTest
public void launch() throws InterruptedException
{
	po.launch();
}
@Test
public void login() throws InterruptedException
{
	po.login();
}
@Test
public void logOut() throws InterruptedException
{
	po.logOut();
}



}

/*@Test
public void login2() throws InterruptedException
{
	po.login2();
}
@Test
public void TopAds() throws InterruptedException{
	po.TopAds();
}
}*/


