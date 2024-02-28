package seleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript {

	public static void main(String[] args) throws Exception {

		// Setting the property of chrome browser and passing chrome driver path
		System.setProperty("webdriver.chrome.driver", "D:\\SoftwareTesting\\JavaWorkspaceST\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

		// JavaScript Executor
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		// Locate Web Element Using JS
		jse.executeScript("document.getElementById('email').value='Arsh123'");
		System.out.println("UserName Entered = " + driver.findElement(By.id("email")).getAttribute("value"));
		jse.executeScript("document.getElementById('pass').value='Arsh@123'");
		System.out.println("Password Enetered = " + driver.findElement(By.id("pass")).getAttribute("value"));

		// Scrolling down using JS
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,500)");

		// Scrolling Up using JS
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,-500)");

		Thread.sleep(2000);
		driver.close();
	}

}
