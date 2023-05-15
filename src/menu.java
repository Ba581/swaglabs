import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class menu extends PARAMETER {
	@Test ()
public void TheMenu () throws InterruptedException {
		
			
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
			driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
			List <WebElement> openmenue=driver.findElements(By.className("menu-item"));
			System.out.println(openmenue.size());
			for(int i=0;i< openmenue.size();i++) {if( i==1) {openmenue.get(1).click();}}
			Thread.sleep(3000);
		WebElement image = driver.findElement(By.cssSelector("[alt=\"Saucelabs\"]"));
		boolean actualvalue = image.isDisplayed();
		myAssertion.assertEquals(actualvalue, true);
	}

}
