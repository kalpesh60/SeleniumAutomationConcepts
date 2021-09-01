package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementSelectors {
	
	public static void chromeBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).click();
		Thread.sleep(3000);
		//FirstName
		//driver.findElement(By.id("u_10_b_m1")).sendKeys("ABC");   //NoSuchElementException
		driver.findElement(By.name("firstname")).sendKeys("ABC");
		//driver.findElement(By.tagName("input")).sendKeys("ABC");    //ElementNotInteractableException
		//driver.findElement(By.className("inputtext _58mg _5dba _2ph-")).sendKeys("ABC");  //NoSuchElementException
		
		//Lastname
		//driver.findElement(By.id("u_10_d_xu")).sendKeys("SBC");     //NoSuchElementException
		driver.findElement(By.name("lastname")).sendKeys("SBC");
		//driver.findElement(By.tagName("input")).sendKeys("SBC");      //ElementNotInteractableException
		//driver.findElement(By.className("inputtext _58mg _5dba _2ph-")).sendKeys("SBC");    //NoSuchElementException
		
		//MobNo
		//driver.findElement(By.id("u_10_g_mI")).sendKeys("4567867567");     //NoSuchElementException
		driver.findElement(By.name("reg_email__")).sendKeys("4567867567");
		//driver.findElement(By.tagName("input")).sendKeys("4567867567");      //ElementNotInteractableException
		//driver.findElement(By.className("inputtext _58mg _5dba _2ph-")).sendKeys("4567867567");    //NoSuchElementException
		
		//Password
		driver.findElement(By.id("password_step_input")).sendKeys("456Aadd$"); 
		//driver.findElement(By.name("reg_passwd__")).sendKeys("456Aadd$");
		//driver.findElement(By.tagName("input")).sendKeys("456Aadd$");      //ElementNotInteractableException
		//driver.findElement(By.className("inputtext _58mg _5dba _2ph-")).sendKeys("456Aadd$");    //NoSuchElementException
		
		//Day
		//driver.findElement(By.id("day")).sendKeys("15"); 
		//driver.findElement(By.name("birthday_day")).sendKeys("4");
		driver.findElement(By.tagName("select")).sendKeys("4");     //select 1st
		//driver.findElement(By.className("_9407 _5dba _9hk6 _8esg")).sendKeys("4");    //NoSuchElementException
		
		//Month
		driver.findElement(By.id("month")).sendKeys("May"); 
		//driver.findElement(By.name("birthday_month")).sendKeys("May");
		//driver.findElement(By.tagName("select")).sendKeys("May");      //not selected
		//driver.findElement(By.className("_9407 _5dba _9hk6 _8esg")).sendKeys("May");    //NoSuchElementException
		
		//Year
		driver.findElement(By.id("year")).sendKeys("2019"); 
		//driver.findElement(By.name("birthday_year")).sendKeys("2019");
		//driver.findElement(By.tagName("select")).sendKeys("2019");      //no error
		//driver.findElement(By.className("_9407 _5dba _9hk6 _8esg")).sendKeys("2019");    //NoSuchElementException
		
		//Male
		//driver.findElement(By.id("u_10_3_qc")).click();                        //NoSuchElementException
		//driver.findElement(By.name("sex")).click();                       //Selects 1st
		//driver.findElement(By.tagName("label")).click();      //Selects 1st
		//driver.findElement(By.className("_8esa")).click();    //Selects 1st
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		
		//Female
		//driver.findElement(By.id("u_10_2_dI")).click();                //NoSuchElementException
		//driver.findElement(By.name("sex")).click();                       //Selects 1st
		//driver.findElement(By.tagName("label")).click();      //Selects 1st
		//driver.findElement(By.className("_8esa")).click();    //Selects 1st
		driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
		
		//Custom
		//driver.findElement(By.id("u_10_4_lu")).click();                //NoSuchElementException
		driver.findElement(By.name("sex")).click();                       //Selects 1st
		//driver.findElement(By.tagName("label")).click();      //Selects 1st
		//driver.findElement(By.className("_8esa")).click();    //Selects 1st
		driver.findElement(By.xpath("//label[contains(text(),'Custom')]"));
		
		driver.findElement(By.linkText("Terms")).click();       //link text
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Data")).click();   //partial link text
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Cookie")).click();           //partial link text
		Thread.sleep(3000); 
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		chromeBrowser();
		Thread.sleep(3000);
	}
}
