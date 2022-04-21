package pack3;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleWindows {

	@Test
	public void getDifferentValues2() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		String idPage1 = driver.getWindowHandle();
		driver.findElement(By.linkText("Open a popup window")).click();
		Set<String>windows = driver.getWindowHandles();
		for (String handle:windows) {
			System.out.println("Handle:"+handle);
		}
		System.out.println("idPage1:"+idPage1);
		Iterator<String> iterateur = windows.iterator();
		while(iterateur.hasNext()) {
			String window = iterateur.next();
			driver.switchTo().window(window);
			if(driver.getTitle().equals("Basic Web Page Title")) {
				String text=driver.findElement(By.id("para1")).getText();
				System.out.println("Paragraph text:"+text);
			}
		}
		driver.switchTo().window(idPage1);
		driver.findElement(By.id("checkbox1")).click();
		//driver.quit();
	}
	
	@Test
	public void getDifferentValues3() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")).click();
		String site=driver.getCurrentUrl();
		System.out.println("Name of website:"+site);
		//driver.quit();
	}
	@Test
	public void ExplicitWaitMechanism() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://omayo.blogspot.com/");
		driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
		//WebElement facebook=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")));
		WebElement facebook=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")));
		facebook.click();
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//div[@id='myDropdown']/a[@href='http://facebook.com']")).click();
		String site=driver.getCurrentUrl();
		System.out.println("Name of website:"+site);
		//driver.quit();
	}
}
