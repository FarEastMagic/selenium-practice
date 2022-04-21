package pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MySecondTest {
	@Test
	public void navigateURL() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Aller sur le URL en question;
		driver.get("https://login.salesforce.com/");
		// Entrer le username;
		driver.findElement(By.className("username")).sendKeys("abc123");
		// Entrer le mot de passe;
		driver.findElement(By.className("password")).sendKeys("abc123");
		// Cliquer sur login;
		driver.findElement(By.id("Login")).click();
		// Definir le WebElement
		WebElement textError = driver.findElement(By.id("error"));
		String erreur = textError.getText();
		System.out.println("Message d'erreur est:" + erreur);
		Thread.sleep(3000);
		driver.close();

	}

	@Test
	public void navigateURL2() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Aller sur le URL en question;
		driver.get("https://login.salesforce.com/");
		// Entrer le username;
		driver.findElement(By.className("username")).sendKeys("abc123");
		// Entrer le mot de passe;
		driver.findElement(By.className("password")).sendKeys("abc123");
		// Cliquer sur login;
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		// Definir le URL et faire un GET
		String URL = driver.getCurrentUrl();
		System.out.println("URL est:" + URL);
		Thread.sleep(3000);
		driver.close();

	}

	@Test
	public void navigateURL3() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Aller sur le URL en question;
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.className("username")).sendKeys("pretest");
		Thread.sleep(4000);
		driver.findElement(By.className("username")).clear();
		Thread.sleep(3000);
		// Entrer le username;
		driver.findElement(By.className("username")).sendKeys("abc123");
		// Entrer le mot de passe;
		driver.findElement(By.className("password")).sendKeys("abc123");
		// Cliquer sur login;
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		//Definir le URL et faire un GET
		String URL=driver.getCurrentUrl();
		System.out.println("URL est:"+URL);
		Thread.sleep(3000);
		driver.close();
	
	}
	
	@Test
	public void navigateURL4() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Aller sur le URL en question;
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.className("username")).sendKeys("pretest");
		Thread.sleep(4000);
		driver.findElement(By.className("username")).clear();
		Thread.sleep(3000);
		// Entrer le username;
		driver.findElement(By.className("username")).sendKeys("abc123");
		// Entrer le mot de passe;
		driver.findElement(By.className("password")).sendKeys("abc123");
		// Cliquer sur login;
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		//Definir le URL et faire un GET
		String URL=driver.getCurrentUrl();
		System.out.println("URL est:"+URL);
		String titre=driver.getTitle();
		System.out.println("Le titre de ma page est: "+titre);
		Thread.sleep(3000);
		String monHTML=driver.getPageSource();
		System.out.println("La page source est: "+monHTML);
		driver.close();
	
	}
	

	@Test
	public void driverQuit() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		driver.findElement(By.linkText("Open a popup window")).click();
		Thread.sleep(3000);
		driver.quit();
	
	}
}
