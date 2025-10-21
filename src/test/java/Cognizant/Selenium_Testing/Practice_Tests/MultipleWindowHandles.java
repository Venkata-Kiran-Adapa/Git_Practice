package Cognizant.Selenium_Testing.Practice_Tests;

import java.time.Duration;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindowHandles {
	@Test
	public void multipleHandles() throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		WebElement searchElement=driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		searchElement.sendKeys("Bags");
		searchElement.sendKeys(Keys.ENTER);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class='results-base']/child::li)[3]"))).click();
		String parent=driver.getWindowHandle();
		Set<String> set=driver.getWindowHandles();
		for(String handle:set) {
			if(!handle.equals(parent)) {
				driver.switchTo().window(handle);
				Thread.sleep(1000);
				System.out.println(driver.getTitle());
			}
		}
	}

}
