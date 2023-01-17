package com.excelr.automationpractise.PractiseExcelR;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoqaRadioButton {
	
	@FindBy(xpath = "//h5[normalize-space()='Elements']")
	private WebElement elements;
	
	@FindBy(xpath = "//span[text()='Radio Button']")
	private WebElement radioBox;
	
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	private WebElement yes;
	
	@FindBy(xpath = "//label[normalize-space()='Impressive']")
	private WebElement impressive;
	
	@FindBy(xpath = "//label[normalize-space()='No']")
	private WebElement no;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		DemoqaRadioButton dRB = PageFactory.initElements(driver, DemoqaRadioButton.class);
		
		js.executeScript("arguments[0].scrollIntoView()", dRB.elements);
		
		dRB.elements.click();
		dRB.radioBox.click();
		dRB.yes.click();
		dRB.impressive.click();
		dRB.no.click();
		
		driver.quit();
	}

}
