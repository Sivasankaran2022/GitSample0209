package org.BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;

	// 1. get driver
	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	// 2. enter url
	public void enterUrl(String url) {
		driver.get(url);
	}

	// 3. maximize window
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// 4. find element by id
	public WebElement elementFindById(String username) {
		WebElement element = driver.findElement(By.id(username));
		return element;
	}

	// 5. sendKeys
	public void elementSendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	// 6. click
	public void elementClick(WebElement element) {
		element.click();
	}

	// 7. getAttribute
	public String elementGetAttribute(WebElement element) {
		String value = element.getAttribute("value");
		return value;
	}

	// 8. getTitle
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 9. getCurrentUrl
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	
	// 10. getText
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 11. elementFindByName
	public WebElement elementFindByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	// 12. elementFindByClassName
	public WebElement elementFindByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	// 13.elementFindByXpath
	public WebElement elementFindByXpath(String attributeValue) {
		WebElement element = driver.findElement(By.xpath(attributeValue));
		return element;
	}

	// 14.getAttribute other thanValue
	public String getAttribute(String attributeName, WebElement element) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	// to get text from text box
	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	// 15.Sleep

	public void sleep(int milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

	// 16.moveToElement
	public void moveToElement(WebElement target) {
		Actions actions = new Actions(driver);
		actions.moveToElement(target).perform();
	}

	// 17.dragAndDrop
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target);
	}

	// 18.contextClick(rightclick)
	public void contextClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	// 19.robot keyPress
	public void robotKeyPress(int keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keycode);
	}

	// 20.robot keyRelease
	public void robotKeyRelease(int keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(keycode);
	}

	// 21.KeyDown
	public void keyDown(CharSequence key) {
		Actions actions = new Actions(driver);
		actions.keyDown(key);
	}

	// 22.KeyUp
	public void keyUp(CharSequence key) {
		Actions actions = new Actions(driver);
		actions.keyUp(key);
	}

	// 23.SendKeys in Actions
	public void sendkeysinactions(WebElement element, CharSequence keycode, String keysToSend) {
		element.sendKeys(keysToSend, keycode);
	}

	// 24.double click
	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// 25.Accept Alert
	public void acceptAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	// 26.Dismiss Alert
	public void dismissAlert() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	// 27.JavaScript insert text
	public void insertTextJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value'," + text + ")", element);
	}

	// 28.JavaScript print text
	public Object printTextJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("return arguemnt[0].getAttribute('value')", element);
		return executeScript;
	}

	// 29.JavaScript click
	public void clickjs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0],click()", element);
	}

	// 30.Scroll Down JavaScript
	public void scrollDownJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(true)", element);
	}

	// 31.Scroll Up JavaScript
	public void scrolUpJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(false)", element);
	}

	// 32.Take Screenshot
	public File screenShot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		return file;
	}

	// 33.Take ScreenShot for WebElement
	public File screenshotWebElement(WebElement element) {
		File file = element.getScreenshotAs(OutputType.FILE);
		return file;
	}

	// 34.Create new File
	public File newFile(String location) {
		File f = new File(location);
		return f;
	}

	// 35.Copy and Paste File
	public void copypastefile(String sourcelocation, String destlocation) throws IOException {
		File s = new File(sourcelocation);
		File d = new File(destlocation);
		FileUtils.copyFile(s, d);
	}

	// 36.Launch url using Navigation
	public void urlNavigation(String url) {
		driver.navigate().to(url);
	}

	// 37.To move Backward in Navigation
	public void moveback() {
		driver.navigate().back();
	}

	// 38.To move Forward
	public void moveforward() {
		driver.navigate().forward();
	}

	// 39.To Refressh
	public void refresh() {
		driver.navigate().refresh();
	}

	// 40.Select By Value in Drop Down
	public void selectByValue(String value, WebElement element) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 41.Select By Index in Drop Down
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	// 42.Select By Visible Text in Drop Down
	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	// 43.get Options in Drop Down
	public List<WebElement> getoptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	// 44.get all options in Drop down
	public void gettAllOptions(WebElement element) {
		Select select = new Select(element);
		select.getAllSelectedOptions();
	}

	// 45.get First option
	public void getFirstOption(WebElement element) {
		Select select = new Select(element);
		select.getFirstSelectedOption();
	}

	// 46.is multiple
	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	// 47.deselectByIndex
	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	// 48.deselect all
	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	// 49.deselect By Value
	public void deselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	// 50.deselectByText
	public void deselectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// 51.SwitchToFrameById
	public void SwitchToFrameByNameOrId(String NameOrId) {
		driver.switchTo().frame(NameOrId);
	}

	// 52.SwitchToFrameByIndex
	public void SwitchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 53.switchToFrameByWebElement
	public void switchToFrameByWebElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// 54.defaultContent
	public void defaultContent() {
		driver.switchTo().defaultContent();
	}

	// 55.getWindowHandle/get Parent Id
	public String getWindowHandle() {
		String parentWinId = driver.getWindowHandle();
		return parentWinId;
	}

	// 56.getWindowHandles/get all windows id
	public Set<String> getWindowHandles() {
		Set<String> allWinId = driver.getWindowHandles();
		return allWinId;
	}

	// 57.switch To Window
	public void switchToWindow(String nameOrHandle) {
		driver.switchTo().window(nameOrHandle);
	}

	// 58.close
	public void close() {
		driver.close();
	}

	// 59.wait
	public void waitMethod() throws InterruptedException {
		driver.wait();

	}

	// 60.clear
	public void clearMethod(WebElement element) {
		element.clear();
	}

	public int getExcelRowNumbers(String filePath, String sheetName) throws IOException {
		File file = new File(filePath);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		return numberOfRows;
	}

	public String getExcelCellValue(String filePath, String sheetName, int rownum, int cellnum) throws IOException {
		File file = new File(filePath);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();
		String value = null;
		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				value = simpleDateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (round == numericCellValue) {
					value = String.valueOf(round);
				} else {
					value = String.valueOf(numericCellValue);
				}
			}
			break;
		default:
			break;
		}
		System.out.println(value);
		return value;
	}

	public void attributeValueWriteInExcel(String filePath, String sheetName, int rownum, int cellnum, String value)
			throws IOException {
		File file = new File(filePath);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(value);
		FileOutputStream stream1 = new FileOutputStream(file);
		workbook.write(stream1);
	}

	public void quit() {
		driver.quit();
	}

}
