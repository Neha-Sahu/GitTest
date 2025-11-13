package Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class DropDown {

	private static final String Assert = null;

	public static void main(String[] args) throws InterruptedException {
		
		
		
			System.setProperty("webdriver.chromedriver", "C:\\Users\\Neha\\eclipse-java-2025-06-R-win32-x86_64\\chromedriver-win64");
			
			WebDriver driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 
			 driver.get("https://www.akasaair.com/");
			 
			// Step 1: Click the dropdown to open currency list
			driver.findElement(By.xpath("//div[@id='currency-select']")).click();
			Thread.sleep(2000L);
		driver.findElement(By.xpath("//div[contains(text(),'Indian Rupee - INR (₹)')]")).click();
		
		
		
		//Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Indian Rupee - INR (₹)')]")).getText(),"Indian Rupee - INR (₹)");
		
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Indian Rupee - INR (₹)')]")).getText());
			 
			 //Step 2-select passenger 4 times
		Thread.sleep(5000L);
			
					 driver.findElement(By.cssSelector("button[name='SelectPassengers']")).click();
					 Thread.sleep(2000L);
					 
					System.out.println(driver.findElement(By.cssSelector("button[name='SelectPassengers']")).getText());
					 
					 int i1=1;
					 while(i1<5)
					 {
						 driver.findElement(By.cssSelector("button[aria-label='Adult(s) Plus'] svg path")).click();
						 i1++;
						 
					 }
					 
					
				     driver.findElement(By.cssSelector("button[aria-label='Done']")).click();
				     System.out.println(driver.findElement(By.cssSelector("button[name='SelectPassengers']")).getText());
				     
				     Thread.sleep(5000L);
				     
				     driver.findElement(By.xpath("//label[@for='From']")).click();
				     Thread.sleep(2000L);
				  
				     driver.findElement(By.xpath("//li[@id='BOM']")).click();
				     Thread.sleep(2000L);
				     
				     driver.findElement(By.xpath("//input[@id='To']")).click();
				     
				     Thread.sleep(2000L);
				     
				     driver.findElement(By.xpath("//li[@id='MAA']")).click();
				     
				    
				    		 driver.findElement(By.xpath(" button[name='Search Flights']")).click();
	}

}
