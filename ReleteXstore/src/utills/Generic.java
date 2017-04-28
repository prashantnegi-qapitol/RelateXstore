package utills;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;



public class Generic {

	public WebDriver driver;	

	public Generic(WebDriver driver){
		this.driver = driver;
	}

	public static void fileUpload(String filePathInProject) throws InterruptedException{
//		System.out.println(filePathInProject);
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println(System.getProperty("user.dir") + filePathInProject);
		
		StringSelection selection = new StringSelection(System.getProperty("user.dir") + filePathInProject);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
		
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	
//	public static void screenshot(String methodName) throws Exception 
//	{
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");                   
//		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//		String screenshotLocationWeb = FilesAndFolders.getPropValue("screenshotLocationWeb");
//		try {
//			FileUtils.copyFile(scrFile, new
//					File((screenshotLocationWeb + methodName + "_" + formater.format(calendar.getTime())+".png")));
//			Reporter.log("<a href='" +
//					screenshotLocationWeb + methodName + "_" + formater.format(calendar.getTime()) + ".png'> <imgsrc='" + screenshotLocationWeb + methodName + "_" + formater.format(calendar.getTime()) + ".png' /> </a>");
//			Reporter.setCurrentTestResult(null);
//		}
//		catch (IOException e1) {
//			e1.printStackTrace();
//		}
//	}

//	public static void quit() throws Exception
//	{
//		driver.quit(); 
//	}
	
//	public static String getPropValue(String key) throws Exception
//	{
//		FileReader reader = new FileReader("./config.properties"); 
//		Properties prop = new Properties();
//		prop.load(reader); 
//
//		String propValue = prop.getProperty(key);
//		return propValue;
//	}

//	public static Cell[] readExcel(String sheetName, String uniqueValue) throws BiffException, IOException,Exception
//	{
//		Workbook wrk1;
//		Sheet sheet1;
//		//Cell colRow;
//
//		String testDataForDefaultReadExcel = getPropValue("testDataForDefaultReadExcel");
//		wrk1 = Workbook.getWorkbook(new File(testDataForDefaultReadExcel)); // Connecting to excel workbook.
//		sheet1 = wrk1.getSheet(sheetName); // Connecting to the sheet
//
//		LabelCell cell=sheet1.findLabelCell(uniqueValue);
//		int row=cell.getRow();
//		Cell[] record = sheet1.getRow(row);
//		return record;
//	}
//
//	public static Cell[] readExcel(String filePath, String sheetName, String uniqueValue) throws BiffException, IOException, Exception
//	{
//		Workbook wrk1;
//		Sheet sheet1;
//
//		wrk1 = Workbook.getWorkbook(new File(filePath)); // Connecting to excel workbook.
//		sheet1 = wrk1.getSheet(sheetName); // Connecting to the sheet
//
//		LabelCell cell=sheet1.findLabelCell(uniqueValue);
//		int row=cell.getRow();
//		Cell[] record = sheet1.getRow(row);
//		return record;
//	}



}
