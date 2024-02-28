package seleniumMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\SoftwareTesting\\JavaWorkspaceST\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		
		// 1st Way
		driver.findElement(By.xpath("//a[contains(@id,'u_0')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='1']")).click(); // Female
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='2']")).click(); // Male
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='-1']")).click(); // Custom
		Thread.sleep(2000);

		// 2nd Way
		List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("Total radio button = " + radios.size()); // 3
		Thread.sleep(2000);
		System.out.println("Male Button Is Selected = " + radios.get(1).isSelected()); // false
		System.out.println("Male Button Is Enabled = " + radios.get(1).isEnabled()); // true
		System.out.println("Male Button Is Displayed = " + radios.get(1).isDisplayed()); // true
		Thread.sleep(2000);
		radios.get(0).click();// Select female button
		System.out.println("Female Button Is Selected = " + radios.get(0).isSelected()); // true
		System.out.println("Female Button Is Enabled = " + radios.get(0).isEnabled()); // true
		System.out.println("Female Button Is Displayed = " + radios.get(0).isDisplayed()); // true
		Thread.sleep(2000);
		System.out.println("Custom Button Is Selected = " + radios.get(2).isSelected()); // false
		System.out.println("Custom Button Is Enabled = " + radios.get(2).isEnabled()); // true
		System.out.println("Custom Button Is Displayed = " + radios.get(2).isDisplayed()); // true
		radios.get(2).click(); // Custom Button Clicked
		Thread.sleep(2000);

		// 3rd Way
		List<WebElement> radiosText = driver.findElements(By.xpath("//label[@class='_58mt']"));
		System.out.println("Total Radio Buttons Text = " + radiosText.size());
		String expResult = "Male";
		for (int i = 0; i < radiosText.size(); i++) {
			if (radiosText.get(i).getText().equalsIgnoreCase(expResult)) {
				radiosText.get(i).click();
				System.out.println(expResult + " Clicked");
				break;
			}
		}
		Thread.sleep(3000);

		driver.close();

	}

}
