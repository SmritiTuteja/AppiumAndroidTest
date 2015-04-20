package com.smriti.appiumtest;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCases {

	// webdriver declaration
	public WebDriver driver;

	public static void main(String[] args) throws Exception {

		// creating a class object
		TestCases testcases = new TestCases();

		// call launch app method
		testcases.launchApp();

		// call add name method
		testcases.addName();
	}

	public void launchApp() throws Exception {

		System.out.println("Launching App");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.3");
		capabilities.setCapability("deviceName", "S3");
		capabilities.setCapability("app", "D:\\Apps\\TestApp.apk");
		capabilities.setCapability("app-package", "com.example.testApp");
		capabilities.setCapability("app-activity", ".SplashActivity");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);

		Thread.sleep(20000); // delay of 20s
		System.out.println("App Launched");
	}

	public void addName() throws InterruptedException {

		System.out.println("Adding Name");
		String myname = "Smriti";
		driver.findElement(By.name("Add")).click();
		driver.findElement(By.xpath("//textfield[1]")).sendKeys(myname);
		driver.findElement(By.name("Save")).click();

		Thread.sleep(5000); // 5s delay
		// write all your tests here

	}
}
