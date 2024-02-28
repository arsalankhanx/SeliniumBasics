package seleniumMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) throws Exception {

		// Setting the property of chrome browser and passing chrome driver path
		System.setProperty("webdriver.chrome.driver", "D:\\SoftwareTesting\\JavaWorkspaceST\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("How stuff works");

		// Hndling Auto Suggestions
		List<WebElement> allSugesstions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		for (int i = 0; i < allSugesstions.size(); i++) {
			String expResult = "how stuff works podcast";
			if (allSugesstions.get(i).getText().equalsIgnoreCase(expResult)) {
				allSugesstions.get(i).click();
				break;
			}

		}
		Thread.sleep(5000);
		driver.close();

	}

}
