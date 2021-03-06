import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AvivaTest {
	WebDriver driver;
	
	  @BeforeTest
	  public void beforeTest() {
		  
		  System.setProperty("phantomjs.binary.path", "/phantomjs/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
		  driver = new PhantomJSDriver();
		System.out.println("stage1");

	  }
  @Test
  public void test1() {
			driver.get("http://127.0.0.1:8080");
			String title = driver.getTitle();	
			System.out.println(title);
			Assert.assertTrue(title.contains("aviva"));	
  }
  @Test
  public void test2() {
	  driver.get("http://127.0.0.1:8080");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-menu")));
		WebElement menu = driver.findElement(By.id("account-menu"));
		menu.click();
		WebElement signin = driver.findElement(By.id("login"));
		signin.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement user = driver.findElement(By.id("username"));
		System.out.println(user);
		user.sendKeys("admin");
		WebElement passwd = driver.findElement(By.id("password"));
		System.out.println(passwd);
		passwd.sendKeys("admin");
		WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[3]/form/button"));
		login.click();
		WebElement error = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/strong"));
		Assert.assertFalse(error.isDisplayed());
  }


  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
