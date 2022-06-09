package week4.day2.assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal extends SnapDealBase {

	public void startApp(ChromeDriver driver) throws InterruptedException, IOException {

		// launch url
		driver.get("https://www.snapdeal.com/");
		// maxime window and add implicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions builder = new Actions(driver);
		// Go to Mens Fashion ,Go to Sports Shoes
		goToMenAndSportsShoes(driver, builder);

		// Get the count of the sports shoes
		System.out.println(driver.findElement(By.xpath("//h1/following-sibling::span")).getText());

		// Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		// Sort by Low to High
		sortByLowToHigh(driver);

		Thread.sleep(5000);
		// Check if the items displayed are sorted correctly
		verifySortOrder(driver);

		// Select the price range
		selectPriceRange(driver);

		Thread.sleep(5000);
		// Filter with color Navy
		driver.findElement(By.xpath("//input[@id='Color_s-Navy']/following-sibling::label")).click();

		Thread.sleep(5000);

		// verify the all applied filters
		verifyAppliedFilters(driver);

		// Mouse Hover on first resulting Training shoes

		builder.moveToElement(driver.findElement(By.xpath("//picture/img"))).perform();

		// click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();

		// Print the cost and the discount percentage
		Thread.sleep(5000);
		printPriceAndDiscountPercentage(driver);

		// Take Screenshot
		takeScreenshot(driver);

		driver.close();

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		SnapDeal snap = new SnapDeal();
		snap.startApp(snap.setUpDriver());

	}

}
