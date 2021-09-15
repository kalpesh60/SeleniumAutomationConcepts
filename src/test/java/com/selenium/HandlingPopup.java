package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingPopup {
	
	public void simpleAlertPopup () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
	    driver.manage().window().maximize();
	    driver.findElement(By.id("alertButton")).click();
	    Thread.sleep(4000);
	    Alert simpleAlert = driver.switchTo().alert();
	    Thread.sleep(3000);
	    simpleAlert.accept();
	}
	
	public void confirmationPopup () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//button[@name='confirmalertbox']")).click();
	    Thread.sleep(3000);
	    Alert confirmationAlert = driver.switchTo().alert();
	    String alertText = confirmationAlert.getText();
	    Thread.sleep(2000);
	    System.out.println("Alert text is " + alertText);
	    confirmationAlert.accept();
	}
	
	public void promptPopup () throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.tizag.com/javascriptT/javascriptprompt.php");  //SeleniumWebdriverException internet not connected
	//find this button : "Say my name"
	driver.findElement(By.xpath("//input[@value='Say my name!']")).click();
	Thread.sleep(2000);
	//Switch to alert pop up 
	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	//print the text present on the alert pop up
	System.out.println(alert.getText());
	Thread.sleep(2000);
	//enter your name in the text box present on the alert pop up
	alert.sendKeys("ajit");
	Thread.sleep(2000);
	//click on OK button
	//alert.accept();
	alert.dismiss();
	Thread.sleep(2000);
	//print the text present on the second alert pop up
	System.out.println(alert.getText());
	//click on Cancel button
	alert.dismiss();
	}
	
	public void promptPopup1 () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//button[@name='promptalertbox1234']")).click();
	    Thread.sleep(3000);
	    Alert confirmationAlert = driver.switchTo().alert();
	    String alertText = confirmationAlert.getText();
	    confirmationAlert.sendKeys("Yes");
	    Thread.sleep(2000);
	    System.out.println("Alert text is " + alertText);
	    confirmationAlert.accept();
	}
	
	public void hiddenDivisionPopup () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Tue, Sep 14')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("24")).click();
	}
	
	public void fileUploadPopup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@multiple='']")).sendKeys("C:\\\\Users\\\\kalpe\\\\OneDrive\\\\Documents\\\\add.txt");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@ng-click=\"item.upload()\"]")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	@SuppressWarnings("deprecation")
	public void fileDownloadPopup() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		//Create Hashmap object and assign the profile settings
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", "C:\\");
		//Assign this chromePrefs object with ChromeOptions object 
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		//Create Capability object and assign the option object
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(cap); 
		driver.get("http://www.seleniumhq.org/download/");
		Thread.sleep(3000);
		String xp = "3.141.59 (November 14, 2018)";
		Thread.sleep(3000);
		driver.findElement(By.linkText(xp)).click();
		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void childWindowPopup() throws InterruptedException { 
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://www.naukri.com/");
		//using getWindowHandles(), get a set of window handle IDs
		Set<String> allWindowHandles = driver.getWindowHandles();
		//using size(), get the count of total number of browser windows
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : "+ count);
		for (String windowHandle : allWindowHandles) {
		//switch to each browser window
		driver.switchTo().window(windowHandle);
		String title = driver.getTitle();
		//print the window handle id of each browser window
		System.out.println("Window handle id of page -->"+ title +" --> is : "+windowHandle);
		//close all the browsers one by on
		}
		Thread.sleep(5000);
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		HandlingPopup handlingPopup = new HandlingPopup();
		Scanner sc = new Scanner(System.in);
		System.out.println(" 1.Simple Alert Popup\n 2.Confirmation Popup\n 3.promptPopup\n 4.Prompt Popup1\n "
				+ "5.Hidden Division Popup\n 6.File Upload Popup\n 7.File Download Popup\n 8.Child Popup Window\n");
		int choice = sc.nextInt();	
		switch (choice) {
		case 1:	handlingPopup.simpleAlertPopup();
			break;
		case 2: handlingPopup.confirmationPopup();
			break;
		case 3: handlingPopup.promptPopup();
			break;
		case 4: handlingPopup.promptPopup1();
			break;
		case 5: handlingPopup.hiddenDivisionPopup();
			break;
		case 6: handlingPopup.fileUploadPopup();
			break;
		case 7: handlingPopup.fileDownloadPopup();
			break;
		case 8: handlingPopup.childWindowPopup();
			break;
		}
	}
}