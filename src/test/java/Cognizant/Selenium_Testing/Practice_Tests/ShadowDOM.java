package Cognizant.Selenium_Testing.Practice_Tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ShadowDOM {

	@Test
	public void shadowDom() {
		WebDriver driver=new EdgeDriver();
		driver.get("https://shop.polymer-project.org/");
		driver.manage().window().maximize();
		
		// Using get Shadow Root
		WebElement parentElement=driver.findElement(By.tagName("shop-app"));
		SearchContext context=parentElement.getShadowRoot();
		WebElement ironPagesElement=context.findElement(By.cssSelector("iron-pages > shop-home"));
		SearchContext nestedContext=ironPagesElement.getShadowRoot();
		WebElement targetElement=nestedContext.findElement(By.cssSelector("div:nth-of-type(1) > a"));
		targetElement.click();
		
		// Using JS
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement targetElementUsingJS = (WebElement) js.executeScript("return document.querySelector('shop-app')"
				+ ".shadowRoot.querySelector('iron-pages').querySelector('shop-home')"
				+ ".shadowRoot.querySelector('div:nth-of-type(1) > shop-button > a')");
		targetElementUsingJS.click();
	}

}
