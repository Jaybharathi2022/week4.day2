package week4.day2.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebTable wt = new WebTable();
		wt.startApp(wt.setUpDriver());

	}

	public void startApp(ChromeDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		// go to url
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();

		// Get the count of number of columns
		List<WebElement> eleCols = driver.findElements(By.xpath("//table//tr[2]/td"));
		System.out.println("Number of columns : " + eleCols.size());

		// Get the count of number of rows
		List<WebElement> eleRows = driver.findElements(By.xpath("//table//tr"));
		System.out.println("Number of rows : " + (eleRows.size() - 1));

		// Get the progress value of 'Learn to interact with Elements'
		getProgressValue(driver, eleRows);

		// Check the vital task for the least completed progress
		checkVitalTaskForLeastProgress(driver, eleRows);
		Thread.sleep(300);
		driver.close();
	}

	public void checkVitalTaskForLeastProgress(ChromeDriver driver, List<WebElement> eleRows) {
		// TODO Auto-generated method stub
		int leastProgress = getLeastProgress(driver);

		for (int i = 2; i <= eleRows.size(); i++) {
			WebElement eleRowval = driver.findElement(By.xpath("//table//tr[" + i + "]/td[2]"));
			int proVal = Integer.valueOf(eleRowval.getText().substring(0, eleRowval.getText().length() - 1));
			if (proVal == leastProgress) {
				driver.findElement(By.xpath("//table//tr[" + i + "]/td[3]/input")).click();
			}
		}
	}

	private int getLeastProgress(ChromeDriver driver) {
		// TODO Auto-generated method stub
		List<WebElement> eleProgressValues = driver.findElements(By.xpath("//table//tr/td[2]"));
		List<Integer> progValList = new ArrayList<Integer>();
		for (WebElement e : eleProgressValues)
			progValList.add(Integer.valueOf(e.getText().substring(0, e.getText().length() - 1)));

		Collections.sort(progValList);

		return progValList.get(0);

	}

	public void getProgressValue(ChromeDriver driver, List<WebElement> eleRows) {
		// TODO Auto-generated method stub
		List<String> progressList = new ArrayList<String>();
		for (int i = 2; i <= eleRows.size(); i++) {

			if (driver.findElement(By.xpath("//table//tr[" + i + "]/td[1]")).getText()
					.equals("Learn to interact with Elements")) {
				progressList.add(driver.findElement(By.xpath("//table//tr[" + i + "]/td[2]")).getText());
			}

		}
		System.out.println("Progress value of 'Learn to interact with Elements : " + progressList);

	}

	public ChromeDriver setUpDriver() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		return driver;

	}

}
