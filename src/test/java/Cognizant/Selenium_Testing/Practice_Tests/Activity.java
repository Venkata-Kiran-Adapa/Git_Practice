package Cognizant.Selenium_Testing.Practice_Tests;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity {
	@Test
	public void randomWord() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://training-support.net/webelements/dynamic-content");
		WebElement btnElement=driver.findElement(By.id("genButton"));
		btnElement.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		boolean contentElement=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "supply"));
		if(contentElement) {
			WebElement content=driver.findElement(By.id("word"));
			System.out.println(content.getText()+" Found");
		}else {
			System.out.println("Not Found");
		}
	}
}
