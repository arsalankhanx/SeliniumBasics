package seleniumMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws Exception {

		// Setting the property of chrome browser and passing chrome driver path
		System.setProperty("webdriver.chrome.driver", "D:\\SoftwareTesting\\JavaWorkspaceST\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

		// Enter Username
		driver.findElement(By.id("email")).sendKeys("Arsh@gmail.com");

		// Fetch input box attribute value
		System.out.println(driver.findElement(By.id("email")).getAttribute("value"));

		// Get height of input box
		System.out.println(driver.findElement(By.id("email")).getSize().getHeight());

		// Get Width of input box
		System.out.println(driver.findElement(By.id("email")).getSize().getWidth());

		// Explicit Wait
		WebDriverWait wt = new WebDriverWait(driver, 30);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass"))).sendKeys("Arsh@123");
		System.out.println(driver.findElement(By.id("pass")).getAttribute("value"));
		Thread.sleep(5000);

		driver.close();

	}

}
