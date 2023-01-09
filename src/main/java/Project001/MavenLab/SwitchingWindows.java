package Project001.MavenLab;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchingWindows {
	
	
	WebDriver driver=new ChromeDriver();
	
@Test
	public void switchingwindows()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepti\\SeleniumClass-Workspace\\chromedriver_win32\\chromedriver.exe");
	
	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String> allWindows=driver.getWindowHandles();
		System.out.println("total number of windows="+allWindows);
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWindows.iterator();
		if(itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();	
		}
		
		System.out.println("Window1 id= "+win1);
		System.out.println("Window2 id= "+win2);
		System.out.println("The title of the window1 is "+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("The title of the window2 is "+driver.getTitle());
		boolean chkBtn=driver.findElement(By.id("w3loginbtn")).isEnabled();
		System.out.println(chkBtn);
        Assert.assertEquals(chkBtn, true);
        driver.findElement(By.id("w3loginbtn")).click();
        driver.findElement(By.name("email")).sendKeys("deeptipatel2003@yahoo.co.in");
        driver.findElement(By.name("current-password")).sendKeys("Aish@1903");
        driver.findElement(By.xpath("//span[contains(text(),'Log in')]")).click();
       // driver.close();
        driver.quit();
        
	}
}
