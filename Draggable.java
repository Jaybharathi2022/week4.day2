package week4.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// setup driver
		WebDriverManager.chromedriver().setup();
		// launch browser
		ChromeDriver driver = new ChromeDriver();
		// go to url
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		// drag element
		WebElement eleDrag = driver.findElement(By.id("draggable"));
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(eleDrag, 100, 100).perform();

		driver.close();

	}

}
