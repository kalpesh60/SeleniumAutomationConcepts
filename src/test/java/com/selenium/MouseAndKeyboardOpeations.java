package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MouseAndKeyboardOpeations {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		Robot robot = new Robot();
		driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).click();
		Thread.sleep(3000);
		robot.mouseMove(830, 300);
		Thread.sleep(3000);
		robot.mouseWheel(8);
		robot.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_CAPS_LOCK);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_F);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_F);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_W);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_W);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		Thread.sleep(2000);
		driver.close();
	}
}
