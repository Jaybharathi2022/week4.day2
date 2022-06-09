package week4.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// set up driver
		WebDriverManager.chromedriver().setup();
		// launch browser
		ChromeDriver driver = new ChromeDriver();
		// go to url
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);
		WebElement eleDrag = driver.findElement(By.xpath("(//h3[text()='Resizable']/following-sibling::div)[3]"));

		Actions builder = new Actions(driver);
		// resize
		builder.clickAndHold(eleDrag).moveByOffset(25, 25).release(eleDrag).perform();
		
		driver.close();

	}

}
