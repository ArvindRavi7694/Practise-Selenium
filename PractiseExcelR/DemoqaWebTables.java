package com.excelr.automationpractise.PractiseExcelR;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoqaWebTables {

	@FindBy(xpath = "//h5[normalize-space()='Elements']")
	private WebElement elements;

	@FindBy(xpath = "//span[text()='Web Tables']")
	private WebElement webTables;

	@FindBy(id = "addNewRecordButton")
	private WebElement addButton;

	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(id = "lastName")
	private WebElement lastName;

	@FindBy(id = "userEmail")
	private WebElement email;

	@FindBy(id = "age")
	private WebElement age;

	@FindBy(id = "salary")
	private WebElement salary;

	@FindBy(id = "department")
	private WebElement department;

	@FindBy(id = "submit")
	private WebElement submit;

	@FindBy(id = "searchBox")
	private WebElement searchBox;
	
	@FindBy(id = "edit-record-4")
	private WebElement editButton;
	
	@FindBy(id = "delete-record-4")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//span[@class='select-wrap -pageSizeOptions']/select")
	private Select rowsPerPage;

	public static void main(String[] args) {

		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://demoqa.com/");

		DemoqaWebTables dWT = PageFactory.initElements(driver, DemoqaWebTables.class);

		js.executeScript("arguments[0].scrollIntoView()", dWT.elements);

		dWT.elements.click();
		
		js.executeScript("arguments[0].scrollIntoView()", dWT.webTables);
		
		dWT.webTables.click();
		dWT.addButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		dWT.firstName.sendKeys("Rajni");
		dWT.lastName.sendKeys("Kamal");
		dWT.email.sendKeys("RK@gmail.com");
		dWT.age.sendKeys("58");
		dWT.salary.sendKeys("85000");
		dWT.department.sendKeys("SDET");
		dWT.submit.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		List<WebElement> firstNameList = driver
				.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][1]"));
		for(WebElement fNL:firstNameList) {
			System.out.println(fNL.getText());
		}
		
		List<WebElement> lastNameList = driver
				.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][2]"));
		for(WebElement lNL:lastNameList) {
			System.out.println(lNL.getText());
		}
		
		List<WebElement> ageList = driver
				.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][3]"));
		for(WebElement aL:ageList) {
			System.out.println(aL.getText());
		}
		
		List<WebElement> emailList = driver
				.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][4]"));
		for(WebElement eL:emailList) {
			System.out.println(eL.getText());
		}
		
		List<WebElement> salaryList = driver
				.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][5]"));
		for(WebElement sL:salaryList) {
			System.out.println(sL.getText());
		}
		
		List<WebElement> departmentList = driver
				.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][6]"));
		for(WebElement dL:departmentList) {
			System.out.println(dL.getText());
		}

		dWT.searchBox.sendKeys("raj");
		dWT.searchBox.sendKeys(Keys.ENTER);
		dWT.searchBox.clear();
		dWT.editButton.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		dWT.salary.sendKeys("95100");
		dWT.submit.click();
		dWT.deleteButton.click();
		
//		js.executeScript("arguments[0].scrollIntoView()", dWT.rowsPerPage);
//		
//		dWT.rowsPerPage.selectByVisibleText("50");
//		dWT.rowsPerPage.selectByVisibleText("25");
//		dWT.rowsPerPage.selectByVisibleText("100");
		
		driver.quit();
		
	}

}
