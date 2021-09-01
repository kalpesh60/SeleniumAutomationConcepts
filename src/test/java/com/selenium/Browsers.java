package com.selenium;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browsers {
	public static WebDriver driver;
	public String WebsiteURL = "https://en-gb.facebook.com/";
	
	public void chromeBrowser() {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(WebsiteURL);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		System.out.println("window handle " + driver.getWindowHandle());
	}
	
	public void edgeBrowser() {
		System.setProperty("webdriver.edge.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(WebsiteURL);
		System.out.println(driver.getTitle());
	}
	
	public void fireFoxBrowser() {
		System.setProperty("webdriver.gecko.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(WebsiteURL);
		System.out.println(driver.getTitle());
	}
	
	public void operaBrowser() {
		System.setProperty("webdriver.opera.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/operadriver.exe");
		driver = new OperaDriver();
		driver.manage().window().maximize();
		driver.get(WebsiteURL);
		System.out.println(driver.getTitle());
		
	}
	
	public static void main(String[] args) throws InterruptedException, IOException{
		Scanner sc = new Scanner(System.in);
		Browsers browsers = new Browsers();
		FacebookElements facebookelements = new FacebookElements();	
		System.out.println(" 1.Chrome-LogIN\n 2.Chrome-SignUp\n "
				           + "3.Edge-LogIn\n 4.Edge-SignUp\n "
				           + "5.Firefox-LogIn\n 6.Firefox-SignUp\n"
				           + " 7.Opera-LogIn\n 8.Opera-SignUp\n");
		int choice = sc.nextInt();	
		switch (choice) {
		case 1:	browsers.chromeBrowser();
		        facebookelements.logInFacebook();
			break;
		case 2: browsers.chromeBrowser();
				facebookelements.signUpFacebook();
			break;
		case 3:	browsers.edgeBrowser();
				facebookelements.logInFacebook();
		    break;
		case 4:	browsers.edgeBrowser(); 
				facebookelements.signUpFacebook();
			break;
		case 5:	browsers.fireFoxBrowser();
				facebookelements.logInFacebook();
			break;	
		case 6: browsers.fireFoxBrowser(); 
				facebookelements.signUpFacebook();
			break;
		case 7: browsers.operaBrowser();
				facebookelements.logInFacebook();
			break;
		case 8: browsers.operaBrowser();
				facebookelements.signUpFacebook();
			break;
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.quit();
	}
}
