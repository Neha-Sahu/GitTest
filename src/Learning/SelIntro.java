package Learning;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SelIntro {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chromedriver", "C:\\Users\\Neha\\eclipse-java-2025-06-R-win32-x86_64\\chromedriver-win64");
		
	WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://www.amazon.com.au/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
	//driver.findElement(By.cssSelector("button[class='a-button-text']")).click();
		
		//driver.findElement(By.cssSelector("input#nav-bb-search")).sendKeys("books");
		
		//driver.findElement(By.cssSelector("input.nav-bb-button")).click();
		
		
		
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("books");
		
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		//1-48 of over 100,000 results for "books"
		
		System.out.println(driver.findElement(By.xpath("//h2[contains(@class, 'a-size-base')]//span[1]")).getText());
		
		//print titles of all books in the page.
		
		// Use findElements() to get a list of all matching WebElements
		
        List<WebElement> bookTitles = driver.findElements(By.cssSelector("a[class='a-link-normal s-line-clamp-4 s-link-style a-text-normal']"));
        
        if (bookTitles.isEmpty()) {
            System.out.println("ERROR: No book titles found. Check the XPath locator.");
            return;
        }
        System.out.println("\n--- Printing " + bookTitles.size() + " Book Titles ---");
        
     // Loop through the list and print the text of each title
        for (int i = 0; i < bookTitles.size(); i++) {
            String title = bookTitles.get(i).getText();
            System.out.println("Title " + (i + 1) + ": " + title);
        }
        System.out.println("--- All Titles Printed ---");
        
        //Actions class mouseOver
        
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector("div[id='nav-link-accountList']"))).build().perform();
        
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).clear();
        
        a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("books").build().perform();
        
        a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).doubleClick().build().perform();
        
     driver.findElement(By.cssSelector("input[id='nav-search-submit-button']")).click();
     
     
     
     
  // Locate the first book title link
     WebElement firstBook = driver.findElement(By.cssSelector("h2[class='a-size-base-plus a-spacing-none a-color-base a-text-normal']"));
     
     a.moveToElement(firstBook).perform();
     
     a.keyDown(Keys.CONTROL).click(firstBook).keyUp(Keys.CONTROL).build().perform();
     
  // Optional: Switch to the new tab
     for (String handle : driver.getWindowHandles()) {
         driver.switchTo().window(handle);
     }
     
     
  // Locate the first book title link
        

  // Print the title of the opened tab
     System.out.println("New Tab Title: " + driver.getTitle());
     driver.getTitle();

      driver.quit();
     
     
               
        }}
      
     
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
		
		

	


