package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadUsingRobotClass {

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Robot robot = new Robot();
		driver.get("https://www.monsterindia.com/seeker/registration?");
		driver.manage().window().maximize();
		//driver.findElement(By.name("userType")).click();
		
		driver.findElement(By.className("browse-text")).click();
		robot.setAutoDelay(2000);
		// Specify the file location with extension
		StringSelection stringSelection = new StringSelection("C:\\Users\\kalpe\\OneDrive\\Documents\\add.txt");
		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.setAutoDelay(1000);
		// Press CTRL+V for paste
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);
		//Press Enter and release Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.setAutoDelay(3000);
		driver.close();
	}

}
