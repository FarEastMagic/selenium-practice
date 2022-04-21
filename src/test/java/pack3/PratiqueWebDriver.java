package pack3;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PratiqueWebDriver {
	@Test
	public void takeScreenshot() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		File screen = driver.findElement(By.cssSelector("[value='orange']")).getScreenshotAs(OutputType.FILE);
		File toFile = new File("Screenshot\\image1.png");
		FileHandler.copy(screen, toFile);
		// driver.close();
	}

	@Test
	public void takeScreenshot2() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		File screen = driver.findElement(By.cssSelector(
				"[src='https://assets.about.me/background/www.softwaretestingcollege.blogspot.com_1330713399_12.jpg']"))
				.getScreenshotAs(OutputType.FILE);
		File toFile = new File("Screenshot\\image2.png");
		FileHandler.copy(screen, toFile);
		// driver.close();
	}

	@Test
	public void takeScreenshot3() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File toFile = new File("Screenshot\\image3.png");
		FileHandler.copy(screen, toFile);
		// driver.close();
	}

	@Test
		public void takeScreenshotAndReport() throws Exception {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			Reporter.log("Ouverture du homepage");
			driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys("standard_user");
			driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("secret_sauce");
			Reporter.log("Remplir le formulaire de login.");
			driver.findElement(By.cssSelector(".submit-button")).click();
			Thread.sleep(2000);
			Reporter.log("Affichage du homepage.");
			driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("react-burger-menu-btn")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("logout_sidebar_link")).click();
			Reporter.log("Faire un logout de la page.");
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File toFile = new File("Screenshot\\image4.png");
			FileHandler.copy(screen, toFile);
			Reporter.log("Fermer le browser.");
			Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\great\\Desktop\\QA Automation\\Eclipe project\\selenium_maven\\Screenshot\\image4.png\">screenshot</a>");
			driver.quit();
		}
	@Test
	public void navigateMethod() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		driver.navigate().to("https://www.google.com");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void findMultipleElementsMethod() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		List<WebElement> maListe=driver.findElements(By.cssSelector("input"));
		//System.out.println("maListe="+maListe);
		for(WebElement element: maListe) {
			String monAttribut=element.getAttribute("name");
			System.out.println("Attribut="+monAttribut);
		}
		driver.quit();
	}
	
	@Test
	public void findMultipleElementsMethod2() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector(".submit-button")).click();
		Thread.sleep(2000);
		List<WebElement> maListe2=driver.findElements(By.cssSelector("a"));
		//System.out.println("maListe2="+maListe2);
		for(WebElement element: maListe2) {
			String monAttribut2=element.getAttribute("href");
			System.out.println("href="+monAttribut2);	
			String linktext=element.getText();
			System.out.println("linkText="+linktext);
		}	
		driver.quit();
	}
	@Test
	public void getDifferentValues() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		//background-color
		WebElement element=driver.findElement(By.cssSelector("#login-button"));
		String color=element.getCssValue("background-color");
		System.out.println("ma couleur="+color);	
		driver.quit();
	}
	
	@Test
	public void getDifferentValues2() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		String nomDriver=driver.getClass().getSimpleName();
		System.out.println("nom driver:"+nomDriver);
		driver.quit();
	}
}
