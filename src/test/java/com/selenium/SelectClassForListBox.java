package com.selenium;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassForListBox {
	
	public void selectClassEx() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, 300)");
		//WebElement list = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
		//getOptions()
		List<WebElement> options = select.getOptions();
		int size = options.size();
		System.out.println("Elements present in list is:" +size);
		Thread.sleep(3000);
		//selectByIndex()
		select.selectByIndex(1);
		//selectByValue()
		select.selectByValue("4");
		//selectByVisibleText()
		select.selectByVisibleText("Green");
		//isMultiple()
		boolean mul = select.isMultiple();
		System.out.println("Multiple select box: " +mul);
		Thread.sleep(3000);
		//getAllSelectedOptions()
		WebElement first = select.getFirstSelectedOption();
		System.out.println("get first selected option: " +first);
		System.out.println(first.getText());
		//getAllSelectedOptions()
		List<WebElement> all = select.getAllSelectedOptions();
		System.out.println("get all selected options: " +all);
		Thread.sleep(3000);
		driver.close();
	}
	
	public void multiSelectClassEx() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, 500)");
		//WebElement list = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(driver.findElement(By.id("cars")));
		//getOptions()
		List<WebElement> options = select.getOptions();
		int size = options.size();
		System.out.println("Elements present in list is:" +size);
		Thread.sleep(3000);
		//selectByIndex()
		select.selectByIndex(1);
		//selectByValue()
		select.selectByValue("audi");
		//selectByVisibleText()
		select.selectByVisibleText("Opel");
		//isMultiple()
		boolean mul = select.isMultiple();
		System.out.println("Multiple select box: " +mul);
		Thread.sleep(3000);
		//getAllSelectedOptions()
		WebElement first = select.getFirstSelectedOption();
		System.out.println("get first selected option: " +first);
		System.out.println(first.getText());
		//getAllSelectedOptions()
		List<WebElement> all = select.getAllSelectedOptions();
		System.out.println("get all selected options: " +all);
		for(WebElement selectedOption: all)
            System.out.println(selectedOption.getText());
		Thread.sleep(3000);
		//deSelectByIndex()
		select.deselectByIndex(1);
		//deSelectByValue()
		select.deselectByValue("audi");
		//deSelectByVisibleText()
		select.deselectByVisibleText("Opel");
		Thread.sleep(3000);
		select.selectByIndex(0);
		select.selectByIndex(1);
		select.selectByIndex(2);
		Thread.sleep(3000);
		//deSelectAll()
		select.deselectAll();
		Thread.sleep(3000);
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		SelectClassForListBox scfl = new SelectClassForListBox();
		Scanner sc = new Scanner(System.in);
		System.out.println(" 1.Select Class Ex\n 2.Multi Select Class\n");
		int choice = sc.nextInt();	
		switch (choice) {
		case 1:	scfl.selectClassEx();
			break;
		case 2: scfl.multiSelectClassEx();
			break;
		}
	}
}
