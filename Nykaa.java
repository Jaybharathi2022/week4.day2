package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa extends NykaaBase {

	public void startApp(ChromeDriver driver) throws InterruptedException {
		// launch url
		driver.get("https://www.nykaa.com/");
		// maximize window
		driver.manage().window().maximize();
		// add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Actions builder = new Actions(driver);
		// Mouseover on Brands and Search L'Oreal Paris and verify
		brandSearchAndVerify(driver, builder);
		// Click sort By and select customer top rated
		sortByCustomerRating(driver);
		// Click Category and click Hair->Click haircare->Shampoo &
		// Click->Concern->Color Protection
		applyFilter(driver);
		// check whether the Filter is applied
		verifyFilters(driver);

		Thread.sleep(300);

		// Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Colour Protect Shampoo')]")).click();

		// GO to the new window and select size as 175ml
		switchToNewWindow(driver);
		selectSize(driver);

		// Print the MRP of the product
		printMrp(driver);

		// Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();

		// Go to Shopping Bag
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();

		Thread.sleep(300);
		driver.switchTo().frame(0);
		// Print the Grand Total amount
		String grandTotal = printGrandTotal(driver);

		// Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']/ancestor::button")).click();
		switchToNewWindow(driver);

		// Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		Thread.sleep(300);
		// Check if this grand total is the same in step 14
		verifyGrandTotal(driver, grandTotal);

		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Nykaa nyk = new Nykaa();
		nyk.startApp(nyk.setUpDriver());

	}

}
