package com.selenium;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsInSelenium {
	
	public void implicitWait() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();   
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  //it will not stop for 20 sec when element find it will execute    
		// Implicit Wait for 20 seconds- it is applicable to all WebElements in the script 
		driver.get("https://www.ebay.com/");  
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("Electronics"));
		action.moveToElement(element).build().perform();
		//Thread.sleep(3000);
		driver.findElement(By.linkText("Apple")).click();
	}
	
	public void explicitWait() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");  
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("Electronics"));
		action.moveToElement(element).build().perform();
		// Implicit Wait for 10 seconds- only for specified elements for specified conditions
		WebDriverWait wait = new WebDriverWait(driver, 10);   //it will not stop for 10 sec when element find it will execute
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apple"))).click();
//		driver.findElement(By.linkText("Apple")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("iPhone 11"))).click();		
	}
	
	public void alertIsPresentCondition() {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        
        WebElement alertbtn = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        alertbtn.click();
 
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert AlertPresent = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert window is now present");
        AlertPresent.accept();
 
        System.out.println("Demo of ExpectedConditions.alertIsPresent successful\n");
	}
	
	public void frameToBeAvailableAndSwitchToIt() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/spinner/");
        driver.manage().window().maximize();
        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are " + iframeElements.size());
        // Scroll where the iFrame is present 
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)", "");
        WebDriverWait wait = new WebDriverWait(driver, 5); 
        //By frame_locator = By.xpath("//*[@id=\"content\"]/iframe");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id=\"content\"]/iframe")));
        // Click the button inside the iFrame 
        By elem_set_value = By.xpath("//button[@id='setvalue']");
        wait.until(ExpectedConditions.presenceOfElementLocated(elem_set_value)).click();
        System.out.println("ExpectedConditions.frameToBeAvailableAndSwitchToIt test successful\n");
	}
	
	public void elementToBeSelected() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://lambdatest.github.io/sample-todo-app/");
        driver.manage().window().maximize();
        WebElement elem_li1 = driver.findElement(By.name("li1"));
        WebElement elem_li2 = driver.findElement(By.name("li2"));
 
        elem_li1.click();
        Thread.sleep(2000);
 
        elem_li2.click();
        Thread.sleep(2000);
 
        WebDriverWait wait = new WebDriverWait(driver, 20);
 
        wait.until(ExpectedConditions.elementToBeSelected(elem_li1));
        wait.until(ExpectedConditions.elementToBeSelected(By.name("li2")));
        //wait.until(ExpectedConditions.elementToBeSelected(By.name("li3")));    //Timeout Exception
        System.out.println("ExpectedConditions.elementToBeSelected test successful\n");
	}
	
	public void fluentWait() {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("Electronics"));
		action.moveToElement(element).build().perform();
		//tells the maximum amount of time for selenium WebDriver to wait for a certain condition (web element) becomes visible
		// it will check for the element on the web page at every 5 seconds for the maximum time of 20 seconds
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)                         
	            .withTimeout(Duration.ofSeconds(20))                        
	            .pollingEvery(Duration.ofSeconds(3))            
	            .ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apple"))).click();
	}

	public static void main(String[] args) throws InterruptedException {
		WaitsInSelenium wait = new WaitsInSelenium();
		Scanner sc = new Scanner(System.in);
		System.out.println(" 1.Implicit wait\n 2.Explicit wait\n 3.Fluent wait\n 4.Alert is Present condition\n "
				+ "5.frameToBeAvailableAndSwitchToIt\n 6.elementToBeSelected\n");
		int choice = sc.nextInt();	
		switch (choice) {
		case 1:	wait.implicitWait();
			break;
		case 2: wait.explicitWait();
			break;
		case 3: wait.fluentWait();
			break;	
		case 4:	wait.alertIsPresentCondition();
			break;
		case 5: wait.frameToBeAvailableAndSwitchToIt();
			break;
		case 6: wait.elementToBeSelected();
			break;		
		}
	}
}
