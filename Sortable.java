package week4.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// set up driver
		WebDriverManager.chromedriver().setup();
		// launch url
		ChromeDriver driver = new ChromeDriver();
		// go to url
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();

		WebElement eleItem1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement eleItem3 = driver.findElement(By.xpath("//li[text()='Item 3']"));

		Actions builder = new Actions(driver);
		// sort elements
		builder.clickAndHold(eleItem3).moveToElement(eleItem1).release().perform();

		driver.close();
	}

}
