package Com;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo2 {
	WebDriver driver;
	  
	@BeforeSuite
	public void openBrowsewr()
	{
		
		
		
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Haha CORPORATION\\Desktop\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
			System.out.println("open browser");
		       System.out.println("Demo");
	}
	@BeforeTest
	public void openURl()
	{
		
		driver.get("https://www.demoblaze.com/index.html");
	}
	@BeforeClass
	public void maximizebrowser()
	{
		System.out.println("windows maximize");
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
	{
		System.out.println("getcookies");
		Set<Cookie> cookies=driver.manage().getCookies();
		for(Cookie c : cookies)
		{
			System.out.println(c.getName());
		}
	}
	@Test(dataProvider="getData")
	public void sinup(String us,String ps,String us1,String us2) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys(us);
		driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys(ps);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys(us1);
		driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys(us2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		driver.switchTo().alert().accept();
		
		
	}
	
	@AfterClass
	  public void deleteCookies()
	  {
		  System.out.println("after class");
		  driver.manage().deleteAllCookies();
	  }
	  @AfterSuite
	  public void afterSuite()
	  {
		  System.out.println("after suite");
		  
	  }
	  @DataProvider
	  public Object getData()
	  {
		  return new Object[][]
				  {
			         new Object[] {"shubham123","shubham@123","shubhamp123","123456s"}
				  };
		 
	  }
}
