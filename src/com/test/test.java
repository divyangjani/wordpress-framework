package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Utills.Excelreader2;
import com.pageobject.Pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
	
	
	@Test(dataProvider = "createpost",dataProviderClass =Excelreader2.class)
	public void testm(String posttitle, String content)
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://wordpress.com/log-in");
		Pageobjects pom=new Pageobjects(driver);
		 pom.username.sendKeys("divyangjani619@gmail.com");	
	       pom.continue_button.click();
	       pom.password.sendKeys("Dixit1234@");
	       pom.signin_button.click();
		pom.Create_post.click();
		pom.post_title.sendKeys(posttitle);
		
	
	}

}
