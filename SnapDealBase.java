package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.google.common.collect.Ordering;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealBase {

	public ChromeDriver setUpDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(setChromeOptions());
		return driver;
	}

	public ChromeOptions setChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		return options;
	}

	public void takeScreenshot(ChromeDriver driver) throws IOException {
		// TODO Auto-generated method stub
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/firstResult.png");
		FileUtils.copyFile(source, destination);

	}

	public void printPriceAndDiscountPercentage(ChromeDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Price : "
				+ driver.findElement(By.xpath("//div[contains(text(),'Price')]/following::div[3]/span")).getText());
		System.out.println("Discount percentage : "
				+ driver.findElement(By.xpath("//div[contains(text(),'Price')]/following::div[3]/span[2]")).getText());
	}

	public void verifyAppliedFilters(ChromeDriver driver) {
		// TODO Auto-generated method stub
		String filterPrice = "Price: Rs. 500 - Rs. 1200";
		String filterColor = "Color: Navy";
		List<WebElement> eleFilters = driver.findElements(By.xpath("//div[@class='navFiltersPill']"));
		for (WebElement e : eleFilters) {
			String filterText = e.getText();

			if (filterPrice.equals(filterText) || filterColor.equals(filterText))
				System.out.println("Filter applied successfully - " + filterText);
		}
	}

	public void selectPriceRange(ChromeDriver driver) {
		// TODO Auto-generated method stub
		WebElement eleFrom = driver.findElement(By.xpath("//input[@name='fromVal']"));
		WebElement eleTo = driver.findElement(By.xpath("//input[@name='toVal']"));

		eleFrom.clear();
		eleFrom.sendKeys("500");
		eleTo.clear();
		eleTo.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();

	}

	public void verifySortOrder(ChromeDriver driver) {
		// TODO Auto-generated method stub
		List<WebElement> eleSorted = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> sortedList = new ArrayList<String>();

		for (WebElement e : eleSorted) {
			sortedList.add(e.getAttribute("display-price"));
		}

		boolean sorted = Ordering.natural().isOrdered(sortedList);
		System.out.println("Items displayed sorted correctly : " + sorted);
	}

	public void sortByLowToHigh(ChromeDriver driver) {
		// TODO Auto-generated method stub
		WebElement eleSortBy = driver.findElement(By.xpath("//span[text()='Sort by:']"));
		eleSortBy.click();
		driver.findElement(By.xpath("//span[text()='Sort by:']/parent::div/following-sibling::ul/li[@data-index='1']"))
				.click();

	}

	public void goToMenAndSportsShoes(ChromeDriver driver, Actions builder) {
		// TODO Auto-generated method stub
		WebElement eleMen = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		WebElement eleSportsShoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		builder.moveToElement(eleMen).pause(1000).click(eleSportsShoes).perform();
	}

}
