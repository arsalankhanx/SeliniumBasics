package seleniumMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\SoftwareTesting\\JavaWorkspaceST\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@id,'u_0')]")).click();
		Thread.sleep(2000);

		// 1st Way
		List<WebElement> birthMonth = driver.findElements(By.xpath("//select[@id='month']/option"));
		System.out.println("Total Dropdown Values = " + birthMonth.size());
		birthMonth.get(8).click(); // Sep
		Thread.sleep(2000);

		// 2nd Way
		WebElement bm = driver.findElement(By.xpath("//select[@id='month']"));
		Select month = new Select(bm);
		month.selectByIndex(11); // Dec
		Thread.sleep(2000);
		month.selectByValue("8"); // Aug
		Thread.sleep(2000);
		month.selectByVisibleText("Apr"); // Apr
		Thread.sleep(2000);

		// 3rd Way
		List<WebElement> dropdown = month.getOptions();
		for (int i = 0; i < dropdown.size(); i++) {
			if (dropdown.get(i).getText().equalsIgnoreCase("Jun")) { // Jun
				dropdown.get(i).click();
			}
		}

		// 4th Way
		Thread.sleep(2000);
		WebElement bm1 = driver.findElement(By.xpath("//select[@id='month']"));
		bm1.sendKeys("Nov"); // Nov
		Thread.sleep(2000);

		// 5th Way
		driver.findElement(By.id("month")).sendKeys("Mar");
		System.out.println(month.getFirstSelectedOption().getText());

		// Check If Dropdown Supports multiple selection
		System.out.println(month.isMultiple()); // false
		month.selectByIndex(11); // Dec
		Thread.sleep(2000);
		month.selectByValue("8"); // Aug
		Thread.sleep(2000);
		month.selectByVisibleText("Apr"); // Apr
		Thread.sleep(2000);

		// Deselect the selected value from dropdown
		month.deselectByIndex(11); // Dec
		Thread.sleep(2000);
		month.deselectByValue("8"); // Aug
		Thread.sleep(2000);
		month.deselectByVisibleText("Apr"); // Apr
		Thread.sleep(2000);
		month.deselectAll();
		driver.close();
	}

}
