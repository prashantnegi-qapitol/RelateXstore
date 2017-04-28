package utills;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BrowserEnvironmentDetails {

	@Test
	public void BrowserDetails() throws IOException, Exception
	{	
		//		if(FilesAndFolders.getPropValue("driverName").equalsIgnoreCase("chromeWinx32")){
		//			Cell[] record = FilesAndFolders.readExcel("browserDetails", "chromeWinx32");
		//			Reporter.log("Browser Name: " + record[1].getContents(), true);
		//			Reporter.log("Browser Version: " + record[2].getContents(), true);


		WebDriver driver= SelectBrowser.getBrowser();
		driver.quit();
	}
}
