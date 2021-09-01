package com.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class FacebookElements extends Browsers {
	
	public void logInFacebook() {
		driver.findElement(By.id("email")).sendKeys("kalpesh@asd.com");
		driver.findElement(By.id("pass")).sendKeys("Abcd123456@1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("login")).click();
	}
	
	public void signUpFacebook() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("firstname")).sendKeys("Kalpesh");
        driver.findElement(By.name("lastname")).sendKeys("Dhalpe");
        driver.findElement(By.name("reg_email__")).sendKeys("7878786543");
        driver.findElement(By.name("reg_passwd__")).sendKeys("Ajyu&1800");
        driver.findElement(By.name("birthday_day")).sendKeys("07");
        driver.findElement(By.name("birthday_month")).sendKeys("June");
        driver.findElement(By.name("birthday_year")).sendKeys("1998");
        driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
        driver.findElement(By.xpath("//label[contains(text(),'Custom')]"));
		Thread.sleep(4000);
        //driver.findElement(By.name("websubmit")).click();
        
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        
    	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
    	
    	File destinationFile = new File("./Screenshot/" +"facebook-signup-"+ System.currentTimeMillis() + ".png");
    	//FileHandler.copy(sourceFile, destinationFile);
    	FileUtils.copyFile(sourceFile, destinationFile);
	}
}
