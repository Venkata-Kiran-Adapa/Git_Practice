package Cognizant.Selenium_Testing.Practice_Tests;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoibiboTest {
	@Test
	public void searchFlights() throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.goibibo.com");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("webpush-onsite")));
		WebElement denyBtn=wait.until(ExpectedConditions.elementToBeClickable(By.id("deny")));
		denyBtn.click();
		driver.switchTo().defaultContent();
		WebElement closeBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@role='presentation']")));
		closeBtn.click();
		WebElement closeBtn2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")));
		closeBtn2.click();		
		
		
		WebElement from = driver.findElement(By.xpath("//p[text()='Enter city or airport']/preceding-sibling::span[text()='From']"));
		Actions actions = new Actions(driver);       
		actions.moveToElement(from).click().perform();
		WebElement fromInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='From']/following-sibling::input[@type='text']")));
		fromInput.sendKeys("Hyderabad");
		Thread.sleep(3000);
		List<WebElement> fromSuggestions = driver.findElements(By.id("autoSuggest-list")); 
		System.out.println("From Suggestions");
		System.out.println();
		System.out.println();
		for(WebElement ele:fromSuggestions) {
			System.out.println(ele.getText());
		}
		WebElement fromClick = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@tabindex='0']")));
		fromClick.click();
		
		WebElement to = driver.findElement(By.xpath("//p[text()='Enter city or airport']/preceding-sibling::span[text()='To']"));
		actions.moveToElement(to).click().perform();


		WebElement toInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='To']/following-sibling::input[@type='text']")));
		toInput.sendKeys("Bengaluru");

		Thread.sleep(3000);
		List<WebElement> toSuggestions = driver.findElements(By.id("autoSuggest-list")); 
		System.out.println();
		System.out.println();
		System.out.println("To Suggestions");
		for(WebElement ele:toSuggestions) {
			System.out.println(ele.getText());
		}
		
		WebElement toClick = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@tabindex='0']")));
		toClick.click();
		
		WebElement searchBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='SEARCH FLIGHTS']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchBtn);
		
		System.out.println();
		System.out.println();
		
		WebElement gotItBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='GOT IT']")));
		gotItBtn.click();
		
		List<WebElement> flights=driver.findElements(By.xpath("//p[@class='boldFont blackText airlineName']"));
		System.out.println("Flight Details");
		for(WebElement ele:flights) {
			System.out.println(ele.getText());
		}
		

		
	}
}
