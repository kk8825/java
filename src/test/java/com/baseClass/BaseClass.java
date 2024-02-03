package com.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {


	public static WebDriver wd;

	public static Select s;
	
	public static Actions a;

	public static void launchBrowser() {
		wd = new ChromeDriver();
	}

	public static void maximizeWindow() {
		wd.manage().window().maximize();

	}

	public static void getUrl(String url) {
		wd.get(url);
	}

	public static void sendKeys(WebElement element, String text) {
		element.sendKeys(text);

	}

	public static void enter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	public static void elementtClick(WebElement element) {
		element.click();
	}

	public void clickOkAlert() {
		Alert a = wd.switchTo().alert();
		a.accept();

	}

	public void clickCancelAlert() {
		Alert a = wd.switchTo().alert();
		a.dismiss();
	}

	public static String getElementText(WebElement element) {
		String text = element.getText();
		return text;

	}

	public static String getInsertedText(WebElement element, String value) {

		String data = element.getAttribute(value);
		return data;
	}

	public static void closeAllWindow() {
		wd.quit();
	}

	public void closeCurrentWindow() {
		wd.close();
	}

	public static String getAppTitle() {
		String title = wd.getTitle();
		return title;
	}

	public static String getCurrenturl() {
		String currentUrl = wd.getCurrentUrl();
		return currentUrl;

	}

	public static void selectByVisibleText(WebElement element, String text) {

		s = new Select(element);
		s.selectByVisibleText(text);
	}

	public static void selectByValue(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);
	}

	public static void selectByIndex(WebElement element, int index) {

		s = new Select(element);
		s.selectByIndex(index);
	}

	public void insertValueByJs(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("argument[0].setAttribute('value','" + text + "')", element);
	}

	public void clickByJs(String element) {

		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("arguments[0].click();", element);
	}

	public void switchtoChildWindow() {

		Set<String> windows = wd.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();

		wd.switchTo().window(childId);
	}

	public void switchtoFrameByIndex(int index) {

		wd.switchTo().frame(index);
	}

	public void switchtoFrameById(String id) {

		wd.switchTo().frame(id);
	}

	public static WebElement findLocatorById(String attributeValue) {

		WebElement element = wd.findElement(By.id(attributeValue));
		return element;
	}

	public static WebElement findLocatorByName(String attributeValue) {

		WebElement element = wd.findElement(By.name(attributeValue));
		return element;
	}

	public static WebElement findLocatorByclassName(String attributeValue) {

		WebElement element = wd.findElement(By.name(attributeValue));
		return element;
	}

	public static WebElement findLocatorByXpath(String xpath) {

		WebElement element = wd.findElement(By.xpath(xpath));
		return element;
	}

	public static List<String> dropDownByText(WebElement element) {

		List<String> listOfText = new ArrayList<String>();
		Select s = new Select(element);

		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText();

		}
		return listOfText;
	}

	public static List<String> dropDownByAttributeValue(WebElement element) {
		List<String> textByvalue = new ArrayList<String>();
		Select s = new Select(element);

		List<WebElement> options = s.getOptions();

		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText();
		}
		return textByvalue;
	}

	public static String firstSelectedOption(WebElement element, String text) {

		s = new Select(element);
		s.selectByVisibleText(text);

		WebElement gfsoption = s.getFirstSelectedOption();
		String firxtText = gfsoption.getText();
		return firxtText;
	}

	public boolean isMultiSelected(WebElement element) {

		s = new Select(element);
		boolean isSelected = s.isMultiple();
		return isSelected;

	}

	public static void implicityWait() {

		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	public static void implicityWaitBySeconds(int secs) {

		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public void visibilityOf(WebElement element) {

		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean isDisplayed(WebElement element) {

		boolean isDisplay = element.isDisplayed();
		return isDisplay;
	}

	public boolean isEnabled(WebElement element) {

		boolean isEnable = element.isEnabled();
		return isEnable;
	}

	public boolean isSelected(WebElement element) {

		boolean isSelect = element.isSelected();
		return isSelect;
	}

	public void desSelectedByIndex(WebElement element, int index) {

		s = new Select(element);
		s.deselectByIndex(index);
	}

	public void desSelectedByVisibleText(WebElement element, String text) {

		s = new Select(element);
		s.deselectByVisibleText(text);
	}

	public void desSelectedByAttribute(WebElement element, String value) {

		s = new Select(element);
		s.deselectByValue(value);
	}

	public void desSelectedByAll(WebElement element) {

		s = new Select(element);
		s.deselectAll();
	}

	public void switchtoParentWindow() {

		String window = wd.getWindowHandle();
		wd.switchTo().window(window);

	}

	public void allWindows() {

		Set<String> allwindows = wd.getWindowHandles();
		Iterator<String> it = allwindows.iterator();

	}

	public void clearText(WebElement element) {

		element.clear();
	}

	public void takesScreenshot(String fileName) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) wd;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File("E:\\GreensSelenium\\DDTestingFramework\\Screenshot\\" + fileName + ".png");
		FileUtils.copyFile(s, d);
	}

	public void takesScreenshotByElement(WebElement element, String fileName) throws IOException {

		File s = element.getScreenshotAs(OutputType.FILE);
		File d = new File("E:\\GreensSelenium\\DDTestingFramework\\Screenshot\\" + fileName + ".png");
		FileUtils.copyFile(s, d);
	}

	public static void mouseHoverForSingleOption(WebElement element) {

		a = new Actions(wd);

		a.moveToElement(element).perform();

	}
	public static void keysArrowDown(WebElement element){
		
		a = new Actions(wd);
		
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		
	}

	public static void dragAnddrop(WebElement source, WebElement destination) {

		a = new Actions(wd);
		a.dragAndDrop(source, destination).perform();

	}

	public void rightClick(WebElement element) {

		a = new Actions(wd);
		a.contextClick(element).perform();
	}

	public void doubleClick(WebElement element) {

		a = new Actions(wd);
		a.doubleClick(element).perform();
	}

	public static void insertText(WebElement element, String text) {

		element.sendKeys(text);

	}

	public static String readCellData(String sheetName, int rownum, int cellNum) throws IOException {

		String res = "";
		File file = new File("E:\\GreensSelenium\\PageObjectModel\\Excel\\OmrDatas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workBook = new XSSFWorkbook(stream);
		Sheet sheet = workBook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simpleDateFormate = new SimpleDateFormat("dd-MM-yyyy");

			} else {
				Double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (check == numericCellValue) {
					res = String.valueOf(check);
				} else {
					res = String.valueOf(numericCellValue);
				}
			}
			break;

		default:
			break;
		}
		return res;
	}

	public static void replaceData(String sheetName, int rownum, int cellNum, String olddata, String newdata)
			throws IOException {

		File file = new File("E:\\GreensSelenium\\PageObjectModel\\Excel\\OmrDatas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workBook = new XSSFWorkbook(stream);
		Sheet sheet = workBook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		if (value.equals(olddata)) {
			cell.setCellValue(newdata);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workBook.write(fileOutputStream);
	}

	public static void insertValueInCell(String sheetName, int rownum, int cellNum, String data) throws IOException {

		File file = new File("E:\\GreensSelenium\\PageObjectModel\\Excel\\OmrDatas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workBook = new XSSFWorkbook(stream);
		Sheet sheet = workBook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);

		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workBook.write(fileOutputStream);
	}

	public static void pageRefresh() {

		wd.navigate().refresh();
	}

}
