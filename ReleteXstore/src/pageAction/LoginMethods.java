package pageAction;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjectLib.Login;
import btac.sa.lib.WebCommonMethods;
import utills.FilesAndFolders;
import utills.SelectBrowser;
public class LoginMethods extends SelectBrowser {
		WebDriver driver;
		Login lp;
		WebCommonMethods wcm;
		String email;
		String password;
		String expectedName;
		
		public LoginMethods(WebDriver driver) {
			this.driver=driver;
			lp= PageFactory.initElements(driver, Login.class);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wcm = PageFactory.initElements(driver, WebCommonMethods.class);
		}
		
		
		public void login() throws BiffException, IOException, Exception{
			
			String url = null;
			Cell[] record = null;
				url = FilesAndFolders.getPropValue("url");
				record = FilesAndFolders.readExcel("login", "Admin01");


			if(!driver.getCurrentUrl().equals(url)){
				driver.navigate().to(url);
			}
			email = record[1].getContents();
			password = record[2].getContents();

			String expectedResult= record[3].getContents(); 


			lp.enterEmailId(email);
			lp.enterPassword(password);
			lp.clickLoginButton();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String browserName = FilesAndFolders.getPropValue("driverName");
			if(browserName.contains("firefox")){
				driver.navigate().refresh();
			}
			
			String actualResult= lp.getUserName();
				
			Assert.assertEquals(actualResult, expectedResult, "It does not match, Username is different");
			Reporter.log("***************login succesfull, "+ expectedResult +" and "+actualResult+" matches*************",true);
		}
		
		
	

}
