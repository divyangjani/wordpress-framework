package com.baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;

import com.Listners.Listner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;

	public static EventFiringWebDriver e_driver;

	public static void browsersetup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		e_driver=new EventFiringWebDriver(driver);
		Listner listner=new Listner();
		e_driver.register(listner);
        driver=e_driver;
		driver.get("https://wordpress.com/log-in");	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@AfterSuite

	public void closebrowser()
	{
		driver.close();
	}





}
