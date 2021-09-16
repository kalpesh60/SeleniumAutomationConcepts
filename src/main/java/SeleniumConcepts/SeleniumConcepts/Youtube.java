package SeleniumConcepts.SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Youtube {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		WebElement element = driver.findElement(By.xpath("//input[@id='search']"));
		element.sendKeys("testing");
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		driver.findElement(By.xpath("//yt-formatted-string[contains(text(),'QA Manual Testing Full Course for Beginners Part-1']/parent::a")).click();
		Thread.sleep(2000);
	}

}
