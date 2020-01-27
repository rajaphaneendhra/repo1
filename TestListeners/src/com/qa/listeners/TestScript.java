package com.qa.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.qa.listeners.TestListner.class)

public class TestScript {
  
	WebDriver driver;
	
//Browser setup
    
    @BeforeClass
    public void envsetup()
    {
    	System.setProperty("webdriver.gecko.driver", "//Users//Raja//Desktop//WebDrivers//geckodriver");
		driver = new FirefoxDriver();  
            
            
            //maximize the screen or window
            
            driver.manage().window().maximize();
            
    }
    
    //Test to pass as to verify listeners.        
    @Test        
    public void Login()                
    {        
        driver.get("http://demo.guru99.com/V4/");                    
        driver.findElement(By.name("uid")).sendKeys("mngr238749");                            
        driver.findElement(By.name("password")).sendKeys("YnAdehe");                            
        driver.findElement(By.name("btnLogin")).click();                    
    }        

    //Forcefully failed this test as verify listener.        
    @Test        
    public void TestToFail()                
    {        
        System.out.println("This method to test fail");                    
        Assert.assertTrue(false);            
    }        
    
    @AfterClass
    public void teardown()
    {
        
        driver.close();
    }
	
	
}
