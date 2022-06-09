package week4.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// setup driver
		WebDriverManager.chromedriver().setup();
		// launch browser
		ChromeDriver driver = new ChromeDriver();
		// go to url
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();

		WebElement eleDrag = driver.findElement(By.id("draggable"));
		WebElement eleDrop = driver.findElement(By.id("droppable"));
		// drag and drop element
		Actions builder = new Actions(driver);
		builder.dragAndDrop(eleDrag, eleDrop).perform();

		driver.close();

	}

}
