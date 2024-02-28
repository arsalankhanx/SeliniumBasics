package seleniumMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {
	public static void main(String[] args) {
		// Setting the property of chrome browser and passing chrome driver path
		System.setProperty("webdriver.chrome.driver", "D:\\SoftwareTesting\\JavaWorkspaceST\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/gainers");

		// Creating List Of AllCompanies
		List<WebElement> allCompanies = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]/a"));
		System.out.println("All Companies Count = " + allCompanies.size());

		// Creating List Of CurrentPrice
		List<WebElement> currentPrice = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		System.out.println("Current Price Count = " + currentPrice.size());

		String expCompName = "Hind Rectifiers";

		for (int i = 0; i < allCompanies.size(); i++) {
			if (allCompanies.get(i).getText().equalsIgnoreCase(expCompName)) {
				System.out.println("Company Name = " + allCompanies.get(i).getText() + " |" + "Current Price = "
						+ currentPrice.get(i).getText());
				allCompanies.get(i).click();
				break;
			}
		}

		driver.close();
	}

}
