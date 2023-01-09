package Project001.MavenLab;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingRadioButton {

	@Test
	public void handlingradio()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deepti\\SeleniumClass-Workspace\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		WebElement radio=driver.findElement(By.xpath("//tbody/tr[24]/td[3]/input[2]"));
		//act.moveToElement(radio).click(radio).build().perform();
		act.moveToElement(radio);
		act.click(radio).build().perform();
		boolean chkRadioSel=driver.findElement(By.xpath("//tbody/tr[24]/td[3]/input[2]")).isSelected();
		System.out.println(chkRadioSel);
		Assert.assertEquals(chkRadioSel, true);
		
		//count no of radio buttons
		Integer count=driver.findElements(By.xpath("//input[@type='radio']")).size();
		System.out.println("total number of radio buttons= "+count);
		driver.quit();
	}
}
