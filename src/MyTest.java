import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MyTest extends PARAMETER {
	@Test()
	public void Add_All_BUTTON () throws IOException, InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();

	  List<WebElement>the_add_button = driver.findElements(By.className("btn_primary"));
	  System.out.println(the_add_button.size());
	  for(int i=0; i<the_add_button.size();i++) {the_add_button.get(i).click();}
	  JavascriptExecutor Js=(JavascriptExecutor)driver;
	  Thread.sleep(3000);
	  Js.executeScript("window.scrollTo(0,10)");
	  Date myDate=new Date ();
	  String myDateUpdate=myDate.toString();
	  String myDateFormate=myDateUpdate.replace(":", "-");
	  //Convert web driver object to TakeScreenshot
	  TakesScreenshot scrshot = ((TakesScreenshot)driver);
	//Call getScreenshotAs method to create image file
	 File SrcFile=scrshot.getScreenshotAs(OutputType.FILE);
	//Move image file to new destination
	 File DestFile=new File("./screenshot/"+myDateFormate +".jpg");
	//Copy file at destination
	FileUtils.copyFile(SrcFile, DestFile);}
	
	
	@Test  ()
	public void Remove_All_Button() throws IOException, InterruptedException {
		List<WebElement>the_remove_button = driver.findElements(By.className("btn_secondary"));
		  //System.out.println(the_remove_button.size());
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		  for(int i=0; i<the_remove_button.size();i++) {the_remove_button.get(i).click();}
		  JavascriptExecutor Js=(JavascriptExecutor)driver;
		  Thread.sleep(4000);
		  Js.executeScript("window.scrollTo(0,10)");
		  Date myDate=new Date ();
		  String myDateUpdate=myDate.toString();
		  String myDateFormate=myDateUpdate.replace(":", "-");
		  //Convert web driver object to TakeScreenshot
		  TakesScreenshot scrshot = ((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		 File SrcFile=scrshot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		 File DestFile=new File("./screenshot/"+myDateFormate +".jpg");
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);}
	
	
	@Test()
	public void Windows_The_Fotter_Page_Logos() throws InterruptedException {
		
		builder.keyDown(Keys.PAGE_DOWN).perform();
	    List<WebElement> logos = driver.findElements(By.cssSelector("[target=\"_blank\"]"));
		//System.out.println(logos.size());
		int randomNumber = rand.nextInt(0,3);
		logos.get(randomNumber).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> pageLogo = new ArrayList<String>(windowHandles);
		 driver.switchTo().window(pageLogo.get(randomNumber));
		 Thread.sleep(10000);
		if(randomNumber==0) {
			 Thread.sleep(3000);
	    String Actualtitle  = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[3]/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/span/span[1]")).getText();
		myAssertion.assertEquals(Actualtitle, "Sauce Labs");
		}
		if(randomNumber==1) {
	   Thread.sleep(3000);
	    String Actualtitle  = driver.findElement(By.xpath("//*[@id=\"login_popup_cta_form\"]/div/div[1]/span/span")).getText();
		myAssertion.assertEquals(Actualtitle, "Connect with Sauce Labs on Facebook");
	}
		if(randomNumber==2) {
			 Thread.sleep(3000);
		    String Actualtitle  = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/form/h1")).getText();
			myAssertion.assertEquals(Actualtitle, "Join LinkedIn");
		}
	}
}


