package com.excelr.automationpractise.PractiseExcelR;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoqaBrokenLinks {
	
	@FindBy(xpath = "//h5[normalize-space()='Elements']")
	private WebElement elements;

	@FindBy(xpath = "//span[text()='Broken Links - Images']")
	private WebElement brokenLinks;
	
	@FindBy(xpath = "//a[normalize-space()='Click Here for Valid Link']")
	private WebElement validLinkOption;
	
	@FindBy(xpath = "//a[normalize-space()='Click Here for Broken Link']")
	private WebElement brokenLinkOption;
	
	@FindBy(xpath = "//a[normalize-space()='here']")
	private WebElement clickHere;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		DemoqaBrokenLinks dBL = PageFactory.initElements(driver, DemoqaBrokenLinks.class);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("https://demoqa.com/");
		
		js.executeScript("arguments[0].scrollIntoView()", dBL.elements);
		dBL.elements.click();
		js.executeScript("arguments[0].scrollIntoView()", dBL.brokenLinks);
		dBL.brokenLinks.click();
		js.executeScript("arguments[0].scrollIntoView()", dBL.validLinkOption);
		dBL.validLinkOption.click();
		
		driver.navigate().back();
		js.executeScript("arguments[0].scrollIntoView()", dBL.brokenLinkOption);
		dBL.brokenLinkOption.click();
		dBL.clickHere.click();
				
		driver.quit();	
	}

}
