package com.excelr.automationpractise.PractiseExcelR;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoqaLinks {

	@FindBy(xpath = "//h5[normalize-space()='Elements']")
	private WebElement elements;

	@FindBy(xpath = "//span[text()='Links']")
	private WebElement links;
	
	@FindBy(id = "simpleLink")
	private WebElement homeLink;
	
	@FindBy(id = "dynamicLink")
	private WebElement homeUO3v6;

	@FindBy(id = "created")
	private WebElement createdLink;
	
	@FindBy(id = "no-content")
	private WebElement nocontentLink;
	
	@FindBy(id = "moved")
	private WebElement movedLink;
	
	@FindBy(id = "bad-request")
	private WebElement badrequestLink;
	
	@FindBy(id = "unauthorized")
	private WebElement unauthorizedLink;
	
	@FindBy(id = "forbidden")
	private WebElement forbiddenLink;
	
	@FindBy(id = "invalid-url")
	private WebElement invalidurlLink;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		DemoqaLinks dL = PageFactory.initElements(driver, DemoqaLinks.class);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("https://demoqa.com/");
		
		js.executeScript("arguments[0].scrollIntoView()", dL.elements);
		dL.elements.click();
		js.executeScript("arguments[0].scrollIntoView()", dL.links);
		dL.links.click();
		
		dL.homeLink.click();
		ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tab.get(0));
		
	    dL.homeUO3v6.click();
	    driver.switchTo().window(tab.get(0));
	    
	    dL.createdLink.click();	    
	    dL.nocontentLink.click();	    
	    dL.movedLink.click();	    
	    dL.badrequestLink.click();	    
	    dL.unauthorizedLink.click();	    
	    dL.forbiddenLink.click();	    
	    dL.invalidurlLink.click();
	    
		driver.quit();
		
		
	}
}
