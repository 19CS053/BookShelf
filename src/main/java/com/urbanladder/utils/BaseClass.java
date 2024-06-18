package com.urbanladder.utils;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;

import io.cucumber.java.Scenario;


public class BaseClass {

	
	private static WebDriver driver; 
	public final static int TIMEOUT = 30;
	static Properties p;
	
	public Logger logger;

	
	//to navigate to site
	public static void openPage(String url) {
		driver.get(url);
	}

	public static WebDriver getDriver() {
		return driver;              
	}

	//to setup the runtime environment
	public static void setUpDriver() {
		
		String env=p.getProperty("env").toLowerCase();
		String browser=p.getProperty("Browser").toLowerCase();
		String os=p.getProperty("os").toLowerCase();
		
		switch(env){
			//to run on local environment
			case "local":
				
					System.out.println("Running on local environment");
					switch(browser) {
						case "chrome":
							driver=new ChromeDriver();
							break;
						case "edge":
							driver=new EdgeDriver();
							break;
						default:
							System.out.println("Not a Valid Browser Option");
					}
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
					break;
			
			//to run on grid environment
			case "remote":
				
					DesiredCapabilities ds=new DesiredCapabilities();
					System.out.println("Running on Grid environment");
					//to select runtime platform
					switch(os) {
						case "windows":
							ds.setPlatform(Platform.WIN11);
							break;
						case "mac":
							ds.setPlatform(Platform.MAC);
							break;
						default:
							System.out.println("Not a Valid Operating System");
					}
					//to select browser
					switch(browser) {
						case "chrome":
							ds.setBrowserName("chrome");
							break;
						case "edge":
							ds.setBrowserName("Microsoft Edge");
							break;
						default:
							System.out.println("Not a Valid Browser Option");
					}
					break;
				
			default:
				System.out.println("Not a Valid Run Environment");
			}
		
	}
	
	
	public static WebDriverWait getWait(long timeDelay) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeDelay));
	}
	
	public static Actions getHandler() {
		return new Actions(driver);
	}
	public static String getUrl() {
		return driver.getCurrentUrl();
	}

	public static void tearDown() {

		if(driver!=null) {

			driver.quit();
		}


	}
	
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void log(Scenario scenario, String data) {
		scenario.attach(data, "text/plain", "data");
	}
	
	//property file 
	public static Properties propfile() throws IOException {
		
			FileReader file = new FileReader("src/test/resources/config.properties");
			p = new Properties();
			p.load(file);
			return p;
		
	}
	
	//To highlight element
	public static void highlightElement(WebElement element) {
		JavascriptExecutor jExecutor=(JavascriptExecutor)BaseClass.getDriver();
		jExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	//to generate log file
	public Logger logElement() {
		logger=LogManager.getLogger(this.getClass());
		return logger;
	}
}