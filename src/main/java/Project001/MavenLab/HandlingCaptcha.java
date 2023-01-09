package Project001.MavenLab;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class HandlingCaptcha {
	
	@Test
	public void handlingcaptcha() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepti\\SeleniumClass-Workspace\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
 driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
 driver.manage().window().maximize();
 
 String str=driver.findElement(By.id("ebcaptchatext")).getText();
 System.out.println(str);
 
 String str1=str.substring(8, 9);
 String str2=str.substring(12, 13);
 System.out.println(str1);
 System.out.println(str2);
 Integer res= Integer.valueOf(str1)+Integer.valueOf(str2);
 System.out.println("Total= "+res);
 driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(res));

 boolean chkBtn=driver.findElement(By.xpath("//body/div[2]/form[1]/input[2]")).isEnabled();
 System.out.println(chkBtn);
 if(chkBtn=true)
 {
 driver.findElement(By.xpath("//body/div[2]/form[1]/input[2]")).click(); 
 }
 else
 {
	 System.out.println("The button is disabled");
 }
 driver.quit();
	
	}
	

}
