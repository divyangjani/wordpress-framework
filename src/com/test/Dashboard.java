package com.test;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import com.Utills.Excelreader2;
import com.Utills.Helper;
import com.baseclass.Baseclass;
import com.pageobject.Pageobjects;


public class Dashboard extends Baseclass {

	public static Pageobjects pom;	

	@BeforeSuite
	public void setupm()
	{
		browsersetup();
		pom=new Pageobjects(driver);	
		System.out.println("done");
		Login.login(pom);

	}

	@Test(priority = 1)
	public void verifytitle() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		String afterlogin_title=driver.getTitle();

		Assert.assertEquals(afterlogin_title,"Log In — WordPress.com");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "createpost",dataProviderClass =Excelreader2.class,dependsOnMethods = "verifytitle")

	public static void create_post(String posttitle,String postcontent) throws InterruptedException
	{

		pom.Create_post.click();

		Thread.sleep(5000);

		if(pom.Document_dialog.isDisplayed()==true)
		{
			pom.Notnow_btn.click();
		}

		pom.post_title.sendKeys(posttitle);

		driver.switchTo().frame(driver.findElement(By.id("tinymce-1_ifr")));

		System.out.println("Switched to the iframe");

		pom.content.sendKeys(postcontent);	    

		driver.switchTo().defaultContent();

		Thread.sleep(3000);

		pom.publish_btn.click();

		System.out.println("clicked");

		pom.publish_btn2.click();

		Helper.waittill_visibilityof(pom.success_message);

		String success_message = pom.success_message.getText();

		System.out.println("post is published and success message displayed is:    "+success_message);

		pom.close_btn.click();

		driver.switchTo().alert().accept();

		pom.Create_post.click();

	}


}
