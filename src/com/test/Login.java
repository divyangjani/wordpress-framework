package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.baseclass.Baseclass;
import com.pageobject.Pageobjects;

public class Login extends Baseclass {
	
	public static Pageobjects  pom;

	
	@BeforeSuite
	public void setupm()
	{
		browsersetup();
		pom=new Pageobjects(driver);	
	}
	
	@Test
	public static void login(Pageobjects pom)
	{
       pom.username.sendKeys("divyangjani619@gmail.com");	
       pom.continue_button.click();
       pom.password.sendKeys("Dixit1234@");
       pom.signin_button.click();
       
       
       
	}



}
