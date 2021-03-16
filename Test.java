package selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;
import java.util.*;


public class Test {

	public static void main(String[] args) throws InterruptedException {
	// 	Selecting google chrome driver
		System.setProperty("webdriver.chrome.driver", "D:\\Soft(kits)\\Java Stuff\\Exe files\\1chromedriver_win32\\chromedriver.exe");
		
	// 	Create our reference variable for the interface webdriver assign object chromedriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
	// 	Use our driver to call method to open a website and check how long the webpage takes to load.

		
		long start = System.currentTimeMillis();
		driver.get("http://demo.testfire.net//");
		
		long finish = System.currentTimeMillis();
		
		long totalTime = finish - start;
		
		System.out.println("Page load time : " + totalTime);
		
//		// 	Maximizing window
			driver.manage().window().maximize();
			Thread.sleep(1000);

// 		Checking if element is present on the webpage (Under normal usage, the login is a MUST on the page and hence we can use it for validating our test)
		
		
		if (driver.findElements(By.xpath("//*[@id=\"LoginLink\"]")).size()!=0){
			
			System.out.println("Page Loaded correctly, Login is present");
			}
		else
			{
			System.out.println("Element missing, Page not loaded correctly");
			}
			
			

		

		
//	//	1.1 Login
//	//	Find Sign In element on page 
//	// 	Going to "Sign in" tab
		driver.findElement(By.xpath("//*[@id=\"LoginLink\"]")).click();
		Thread.sleep(500);
		
		
		
		
		
//	// 	sendKeys for sending data from keyboard to different fields (username/password) and enter these credentials for login.
		driver.findElement(By.xpath("//*[@id=\"uid\"]")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"passw\"]")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input")).click();
		Thread.sleep(1000);
		
//		Visually inspecting the dropdown:
		driver.findElement(By.xpath("//*[@id=\"listAccounts\"]")).click();
		Thread.sleep(1000);

		
		
		
//		List<WebElement> dynamicElement1 = driver.findElements(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/form/table/tbody/tr[1]/td[2]/select/option[1]"));
// 		Multiple choices of finding the element (xpath or css selector)		
		List<WebElement> dynamicElement1 = driver.findElements(By.cssSelector("#listAccounts > option:nth-child(1)"));
				
		if(dynamicElement1.size() != 0){

		//If list size is non-zero, element is present

		System.out.println("Element1 is present");

		}

		else{

		//Else if size is 0, then element is not present

		System.out.println("Elements are missing");

		}
		
//		List<WebElement> dynamicElement2 = driver.findElements(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/form/table/tbody/tr[1]/td[2]/select/option[2]"));
// 		Multiple choices of finding the element (xpath or css selector)
		List<WebElement> dynamicElement2 = driver.findElements(By.cssSelector("#listAccounts > option:nth-child(2)"));

		if(dynamicElement2.size() != 0){

		//If list size is non-zero, element is present

		System.out.println("Element2 is present");

		}

		else{

		//Else if size is 0, then element is not present

		System.out.println("Elements are missing");

		}
		
		
		Thread.sleep(3000);

		System.out.println("Logging out. . .");
		
		Thread.sleep(1000);

		
// 		Logging out the account
		driver.findElement(By.xpath("//*[@id=\"LoginLink\"]")).click();
		Thread.sleep(1000);


		driver.close();
	}

}
