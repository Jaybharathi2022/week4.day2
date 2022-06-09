package week4.day2.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaBase {

	public ChromeDriver setUpDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;
	}

	public void brandSearchAndVerify(ChromeDriver driver, Actions builder) {
		String brandName = "L'Oreal Paris";

		WebElement eleBrand = driver.findElement(By.xpath("//a[text()='brands']"));
		WebElement eleBrandSearch = driver.findElement(By.id("brandSearchBox"));
		WebElement eleLoreal = driver.findElement(By.xpath("//a[contains(text(),'Paris')]"));
		// Mouseover on Brands and Search L'Oreal Paris & Click L'Oreal Paris
		builder.moveToElement(eleBrand).pause(5).moveToElement(eleBrandSearch).click().sendKeys(brandName).pause(5)
				.click(eleLoreal).perform();
		// Check the title contains L'Oreal Paris
		if (driver.getTitle().contains(brandName))
			System.out.println("Search for brand " + brandName + " success : Page Title : " + driver.getTitle());

	}

	public void sortByCustomerRating(ChromeDriver driver) {
		// Click sort By and select customer top rated
		WebElement eleSortBy = driver.findElement(By.xpath("//span[contains(text(),'Sort')]"));

		eleSortBy.click();

		WebElement eleCustomerTopRated = driver
				.findElement(By.xpath("//span[contains(text(),'customer')]/parent::div/following-sibling::div"));
		eleCustomerTopRated.click();

	}

	public void applyFilter(ChromeDriver driver) throws InterruptedException {

		// Click Category and click Hair->Click haircare->Shampoo

		WebElement eleCategory = driver.findElement(By.xpath("//span[text()='Category']"));

		eleCategory.click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Shampoo']/parent::div/following::div")).click();

		// Click->Concern->Color Protection

		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//span[text()='Color Protection']/parent::div/following-sibling::div")).click();

	}

	public void verifyFilters(ChromeDriver driver) {
		// check whether the Filter is applied with Shampoo
		List<WebElement> eleAppliedFilters = driver.findElements(By.xpath("//span[@class='filter-value']"));
		for (WebElement e : eleAppliedFilters) {
			if (e.getText().contains("Shampoo") || e.getText().contains("Color Protection")) {
				System.out.println("Filter applied successfully : " + e.getText());
			}
		}
	}

	public void selectSize(ChromeDriver driver) {
		WebElement eleSize = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select selSize = new Select(eleSize);
		selSize.selectByVisibleText("175ml");
	}

	public void switchToNewWindow(ChromeDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winList.get(1));
	}

	public void verifyGrandTotal(ChromeDriver driver, String grandTotal) {
		// TODO Auto-generated method stub
		WebElement eleGrandTot = driver
				.findElement(By.xpath("//div[text()='Grand Total']/parent::div/div[@class='value']/span"));
		String nGrandTotal = grandTotal.substring(1, grandTotal.length());
		if (nGrandTotal.equals(eleGrandTot.getText()))
			System.out.println("Grand Total are same");
	}

	public String printGrandTotal(ChromeDriver driver) {
		// TODO Auto-generated method stub
		WebElement eleGrandTotal = driver
				.findElement(By.xpath("//span[text()='Grand Total']/parent::div/following-sibling::div"));
		String grandTotal = eleGrandTotal.getText();

		System.out.println("Grand Total is : " + grandTotal.substring(1));
		return grandTotal;

	}

	public void printMrp(ChromeDriver driver) {
		// TODO Auto-generated method stub
		WebElement eleMRP = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span"));
		String pdtMRP = eleMRP.getText();
		String nPdtMRP = pdtMRP.substring(1);
		System.out.println("MRP of the producty: " + nPdtMRP);

	}

}
