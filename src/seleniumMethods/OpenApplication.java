package seleniumMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenApplication {
	public static void main(String[] args) throws Exception {

		// Setting The Property Of Chrome Driver and Passing Chrome Driver Path.
		System.setProperty("webdriver.chrome.driver", "D:\\SoftwareTesting\\JavaWorkspaceST\\chromedriver.exe");

		// Launching Chrome Driver Instance | Open Chrome Browser
		WebDriver driver = new ChromeDriver();

		// Open Url Using get() Method.| WebDriver Method
		driver.get("https://www.facebook.com/");

		// Maximize The Browser | WebDriver Method
		driver.manage().window().maximize();

		// Hold The Execution Of Web Page For Sometime
		Thread.sleep(2000);

		// Delete All Cookies | WebDriver Method
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);

		// Open Url Using Url Method | WebDriver Method
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(2000);

		// Refresh The Page | WebDriver Method
		driver.navigate().refresh();
		Thread.sleep(2000);

		// Navigate To Back | WebDriver Method
		driver.navigate().back();
		Thread.sleep(2000);

		// Navigate To Forward | WebDriver Method
		driver.navigate().forward();
		Thread.sleep(2000);

		// Fetch Current Url
		System.err.println(driver.getCurrentUrl());
		Thread.sleep(2000);

		// Get Title Of The Web Page
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.navigate().back();
		Thread.sleep(2000);

		System.err.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys("Pass@123");
		Thread.sleep(2000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);

		driver.navigate().back();
		Thread.sleep(2000);

		driver.navigate().refresh();
		Thread.sleep(2000);

		// Close The Browser
		driver.close();

	}
}
