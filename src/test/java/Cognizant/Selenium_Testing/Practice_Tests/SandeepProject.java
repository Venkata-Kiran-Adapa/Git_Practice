package Cognizant.Selenium_Testing.Practice_Tests;
import java.time.Duration;
import java.util.List;
 
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SandeepProject {
	@Test
    public void deleting() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions a = new Actions(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
        WebElement adm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        Thread.sleep(2000);
        a.moveToElement(adm).click().perform();
 
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='oxd-main-menu-item']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span/i"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Job Categories']"))).click();
        Thread.sleep(2000);
 
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")));
        a.moveToElement(button).click().perform();
 
        // Check if "Test Engineer" already exists in the table
        List<WebElement> categories = driver.findElements(By.xpath("//div[@class='oxd-table-card']//div[2]"));
        boolean testEngineerExists = false;
        for (WebElement category : categories) {
            if (category.getText().equalsIgnoreCase("Test Engineer")) {
                testEngineerExists = true;
                break;
            }
        }
 
        // If not exists, add it
        if (!testEngineerExists) {
            WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[contains(@class, 'oxd-input')])[2]")));
            inputField.sendKeys("Test Engineer");
 
            WebElement save = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")));
            a.moveToElement(save).click().perform();
 
            Thread.sleep(2000); // wait for the new row to appear
        }
 
        // ✅ This part now runs regardless of whether "Test Engineer" was added or already existed
        WebElement topCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@class='oxd-checkbox-wrapper']/child::label")));
        topCheckbox.click();
 
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[contains(@class,'oxd-button--label-danger')]")));
        deleteButton.click();
 
        WebElement confirmDelete = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")));
        confirmDelete.click();
        
        Thread.sleep(2000);
        
        WebElement organization = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item' and contains(text(),'Organization')]")));
        organization.click();
        
        WebElement locations = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='oxd-topbar-body-nav-tab-link' and contains(text(),'Locations')]")));
        locations.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"))).sendKeys("Hyderabad");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='']/input)[2]"))).sendKeys("Hyderabad");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"))).click();
        WebElement lawdaElement=driver.findElement(By.xpath("//div[@class='oxd-select-wrapper']"));
        Thread.sleep(2000);
        lawdaElement.sendKeys("India");
 
       
    
    }
}
