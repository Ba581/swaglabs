import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class PARAMETER {
	WebDriver driver;
	SoftAssert myAssertion;
	Actions builder ;
	Random rand;
	@BeforeTest
	public void setup(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");  
		 driver = new ChromeDriver(options);
		 myAssertion=new SoftAssert();
		 builder = new Actions (driver);
		 rand = new Random();
		driver.get("https://www.saucedemo.com/");
		
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
	}
	@AfterTest
	public void closed() {
//		driver.close();
		
	}

}
