package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	  public WebDriver driver;
	public Properties prop;
	public Properties prop1;
public WebDriver initializeDriver(ChromeOptions options) throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("C:\\work\\workspace\\BGP Assignment\\src\\main\\java\\resources\\testdata.properties");
prop.load(fis);

prop1 = new Properties();
FileInputStream fis1=new FileInputStream("C:\\work\\workspace\\BGP Assignment\\src\\main\\java\\resources\\object.properties");
prop1.load(fis1);

String browserName=prop.getProperty("browser");
//System.out.println(browserName);

if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", "D://training//chromedriver.exe");
	driver= new ChromeDriver();
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	System.setProperty("webdriver.firefox.driver", "D://training//chromedriver.exe"); 
	driver= new FirefoxDriver();
	
}
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;
}

public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	
}


}
