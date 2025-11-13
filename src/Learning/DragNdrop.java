package Learning;

	import org.openqa.selenium.By;
	import org.openqa.selenium.SearchContext;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

	public class DragNdrop {

		private static final By columndriver = null;

		public static void main(String[] args)throws InterruptedException { 
			System.setProperty("webdriver.chromedriver", "C:\\Users\\Neha\\eclipse-java-2025-06-R-win32-x86_64\\chromedriver-win64");
			
			WebDriver driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 
			 driver.get("https://jqueryui.com/droppable/");
			 
			 driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
			 
		WebElement source=	driver.findElement(By.cssSelector("div[id='draggable']"));
		WebElement target=	driver.findElement(By.cssSelector("div[id='droppable']"));
			
			Actions a= new Actions(driver);
			
			
			
			a.dragAndDrop(source, target).build().perform();
			//driver.findElement(By.cssSelector("input.nav-bb-button")).click();
			
			
			
			
			
				
				
					}

		
				
			
		}





