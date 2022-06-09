package week4.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// set up driver
		WebDriverManager.chromedriver().setup();
		// launch browser
		ChromeDriver driver = new ChromeDriver();
		// go to url
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();

		WebElement eleItem1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement eleItem2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement eleItem4 = driver.findElement(By.xpath("//li[text()='Item 4']"));

		// select elements using keysDown & Up
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(eleItem1).click(eleItem2).click(eleItem4).keyUp(Keys.CONTROL).perform();

		WebElement eleItem6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		WebElement eleItem7 = driver.findElement(By.xpath("//li[text()='Item 7']"));

		// select elements using ClickAndHold

		builder.clickAndHold(eleItem6).clickAndHold(eleItem7).release().perform();

		driver.close();

	}

}
