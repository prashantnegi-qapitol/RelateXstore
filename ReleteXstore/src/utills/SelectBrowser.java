
package utills;

import java.util.HashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class SelectBrowser {

	/**
	 * Instantiates a new select browser.
	 */
	public SelectBrowser()
	{
		super();
	}

	
	public static String getBrowserAndVersion(WebDriver wd) {
		String browser_version = null;
		Capabilities cap = ((RemoteWebDriver) wd).getCapabilities();
		
		String browsername = cap.getBrowserName();
		// This block to find out IE Version number
		if (browsername.equalsIgnoreCase("internet explorer") ) {
			String uAgent = (String) ((JavascriptExecutor) wd).executeScript("return navigator.userAgent;");
			System.out.println(uAgent);
			//uAgent return as "MSIE 8.0 Windows" for IE8
			if (uAgent.contains("MSIE") && uAgent.contains("Windows")) {
				browser_version = uAgent.substring(uAgent.indexOf("MSIE")+5, uAgent.indexOf("Windows")-2);
			} else if (uAgent.contains("Trident/7.0")) {
				browser_version = "11.0";
			} else {
				browser_version = "0.0";
			}
		} else
		{
			//Browser version for Firefox and Chrome
			browser_version = cap.getVersion().toString();// .split(".")[0];
		}
		//String browserversion = browser_version.substring(0, browser_version.indexOf("."));
		String browserversion = browser_version;

		return "Browser Details: " + browsername + "_v" + browserversion;
	}
 
	
	/**
	 * Gets the browser.
	 *
	 * @return the browser
	 * @throws Exception 
	 */
	public static WebDriver getBrowser() throws Exception {
		WebDriver driver = null;
		
		String browserName = FilesAndFolders.getPropValue("driverName");
		System.out.println("Browser name is :" + browserName);
		

		//Select Browser logic

		//Firefox
		if(browserName.equalsIgnoreCase("FFGeckoWin64")){	
			String FFGeckoWin64 = FilesAndFolders.getPropValue("FFGeckoWin64");	
			System.setProperty("webdriver.gecko.driver", FFGeckoWin64); // setting path of the Gecko Driver
			driver = new FirefoxDriver(FirefoxDriverProfile());
			System.out.println("Browser session initiated...");
			
			Reporter.log(getBrowserAndVersion(driver),true);
		}
		
		//Firefox-Mac
		else if(browserName.equalsIgnoreCase("FFGeckoMac64")){	
			String FFGeckoMac64 = FilesAndFolders.getPropValue("FFGeckoMac64");	
			System.setProperty("webdriver.gecko.driver", FFGeckoMac64); // setting path of the Gecko Driver
			driver = new FirefoxDriver(FirefoxDriverProfile());
			System.out.println("Browser session initiated...");
			
			Reporter.log(getBrowserAndVersion(driver),true);
		}
		
		//Chrome Mac
		else if(browserName.equalsIgnoreCase("chromeMac64")){
			String chromeMac64 = FilesAndFolders.getPropValue("chromeMac64");	
			System.setProperty("webdriver.chrome.driver", chromeMac64); // setting path of the ChromeDriver
			driver = new ChromeDriver(chromeDriverProfile());
			System.out.println("Browser session initiated...");
			
			Reporter.log(getBrowserAndVersion(driver),true);
		}
		
		
		//Chrome
		else if(browserName.equalsIgnoreCase("chromeWinx32")){
			String chromeWin32 = FilesAndFolders.getPropValue("chromeWinx32");	
			System.setProperty("webdriver.chrome.driver", chromeWin32); // setting path of the ChromeDriver
			driver = new ChromeDriver(chromeDriverProfile());
			System.out.println("Browser session initiated...");
			
			Reporter.log(getBrowserAndVersion(driver),true);
		}
		
		//IE
		else if(browserName.equalsIgnoreCase("ieWinx32")){
			String ieWinx32 = FilesAndFolders.getPropValue("ieWinx32");	
			System.setProperty("webdriver.ie.driver", ieWinx32); // setting path of the ChromeDriver
			driver = new InternetExplorerDriver();
			System.out.println("Browser session initiated...");
			
			Reporter.log(getBrowserAndVersion(driver),true);
		}
		
		//Microsoft Edge
		else if(browserName.equalsIgnoreCase("edgeWin64")){
			String edgeWin64 = FilesAndFolders.getPropValue("edgeWin64");	
			System.setProperty("webdriver.edge.driver", edgeWin64); // setting path of the ChromeDriver
			driver = new EdgeDriver();
			System.out.println("Browser session initiated...");
			
			Reporter.log(getBrowserAndVersion(driver),true);
		}
		
		//Safari MAC
				else if(browserName.equalsIgnoreCase("safari")){
//					String edgeWin64 = FilesAndFolders.getPropValue("edgeWin64");	
//					System.setProperty("webdriver.edge.driver", edgeWin64); // setting path of the ChromeDriver
					driver = new SafariDriver();
					System.out.println("Browser session initiated...");
					
					Reporter.log(getBrowserAndVersion(driver),true);
				}


		
		driver.manage().window().maximize();
		return driver;
	}
	
	
	//Set chrome profile to locate particular download folder
	public static DesiredCapabilities chromeDriverProfile(){
		String downloadFilepath = System.getProperty("user.dir") + "\\downloads";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return cap;
	}
	
	//Set firefox profile to located particular download folder
	public static FirefoxProfile FirefoxDriverProfile() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", System.getProperty("user.dir") + "\\Downloads" );
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
		return profile;
	}
}
