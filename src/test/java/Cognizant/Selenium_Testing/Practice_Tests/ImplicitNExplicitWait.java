package Cognizant.Selenium_Testing.Practice_Tests;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitNExplicitWait {
	@Test
	public void printTestExplicit() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/ajax");
		WebElement btnElement=driver.findElement(By.xpath("//button[text()='Change Content']"));
		btnElement.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		boolean contentElement=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h3"), "I'm late!"));
		if(contentElement) {
			WebElement content=driver.findElement(By.xpath("//h3"));
			System.out.println(content.getText());
		}
	}
	
	 @Test
	    public void printTestImplicit() {
	        WebDriver driver = new ChromeDriver();

	        // Set implicit wait
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.get("https://v1.training-support.net/selenium/ajax");

	        WebElement btnElement = driver.findElement(By.xpath("//button[text()='Change Content']"));
	        btnElement.click();

	        // No explicit wait here — relying on implicit wait
	        WebElement content = driver.findElement(By.xpath("//h3"));
	        System.out.println(content.getText());

	        driver.quit();
	    }
	 
	
	     public void fluentWaitExample() throws InterruptedException {
	         WebDriver driver = new ChromeDriver();
	         driver.get("https://training-support.net/selenium/dynamic-content");
	         driver.findElement(By.id("genbutton")).click();

	         Wait<WebDriver> fluentwait = new FluentWait<>(driver)
	             .withTimeout(Duration.ofSeconds(10))
	             .pollingEvery(Duration.ofMillis(1000))
	             .ignoring(NoSuchElementException.class);

	         fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "meaning"));

	         String text = driver.findElement(By.id("word")).getText();
	         System.out.println(text);
//	         Select s=new Select();
	         driver.close();
	     }
	 }


