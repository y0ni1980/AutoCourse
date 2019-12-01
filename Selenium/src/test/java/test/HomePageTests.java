package test;

import org.testng.annotations.Test;

import core.BaseDriver;
import junit.framework.Assert;
import pages.HomePage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class HomePageTests extends BaseDriver {
	
  @BeforeMethod
	  public void beforeMethod() throws InterruptedException {
	  
  		startSession();
  		PageFactory.initElements(driver, HomePage.class);
  		
  }
  
  @Test(priority=3, groups="Sanity, Regression")
  public void SingleInputFieldTest() throws InterruptedException  {
	  HomePage.EnterMessage.sendKeys("Yoni");
	  HomePage.ShowMessageButton.click();
	  String text = HomePage.DispalyMessage.getText();
	  System.out.println(text);
//	  Assert.assertTrue(text.equals("Yoni"));
//	  Assert.assertEquals("Yokkni", HomePage.DispalyMessage.getText());
	  Assert.assertTrue(HomePage.DispalyMessage.isDisplayed());
	  
  }
  @Test (priority=1, groups="Sanity")
  public void SingleInputFieldTest1() throws InterruptedException  {
	  HomePage.EnterMessage.sendKeys("Motorola");
	  HomePage.ShowMessageButton.click();
	  String text = HomePage.DispalyMessage.getText();
	  System.out.println(text);
//	  Assert.assertTrue(text.equals("Yoni"));
//	  Assert.assertEquals("Yokkni", HomePage.DispalyMessage.getText());
	  Assert.assertFalse(HomePage.DispalyMessage.isDisplayed());
	  
  }
  
  
  
  
  
  @AfterMethod
  public void afterMethod() {
	  stopSession();
  }

}
