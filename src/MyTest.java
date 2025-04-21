
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest {

	WebDriver driver = new EdgeDriver();

	String THEWEBSITE = "https://www.saucedemo.com/";

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.get(THEWEBSITE);
	}

	@Test(priority = 1)
	public void loginproccess() throws InterruptedException {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();

	}
	@Test (priority=2)
	public void AddAllItem() {
		List<WebElement> AddToCart=driver.findElements(By.className("btn"));
		for(int i=0;i<AddToCart.size();i++) {
			AddToCart.get(i).click();
		}
	}

	@Test (priority=3)
	public void PrintFirstLetter() {
		
		List<WebElement> ItemsName=driver.findElements(By.className("inventory_item_name"));
		for(int i=0;i<ItemsName.size();i++) {
			String ItemName=ItemsName.get(i).getText();
			if (ItemName.startsWith("S")) {
			System.out.println(ItemName.charAt(0));}
			
		}
	}
	@Test(priority=4)
	public void ExceptLetterT() {
		List<WebElement> ItemsNames=driver.findElements(By.className("inventory_item_name"));
		for(int i=0;i<ItemsNames.size();i++) {
			String ItemName=ItemsNames.get(i).getText();
			if(!ItemName.endsWith("t")) {
				System.out.println(ItemName);
				}
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	@Test(priority = 2,enabled = false)
	public void addRandomItem() throws InterruptedException {

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 3,enabled = false)
	public void DeleteItem() {
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
	}
	@Test (priority=4,enabled = false)
	public void LogOut()  {
		driver.findElement(By.id("react-burger-menu-btn")).click();

		driver.findElement(By.id("logout_sidebar_link")).click();
	}
	

	@AfterTest
	public void myAfterTest() {

//		driver.quit();
	}

}
