import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogsCapture {

	public static void main(String[] args) {
	
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("div p a[routerlink=\"/products\"]")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.cssSelector("a[href=\"/angularAppdemo/cart\"]")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER); //Get log entries object 
		
		List<LogEntry> logs = entry.getAll(); //LogEntryobject - getAll method return all logs 
		
		// For getting failed test cases we need to use listeners so that once test case filed it automatically get the error logs 
		// In the current test case, we know that where the test case will fail but in real time, we don't where the test case will fail so we need to use Listeners so that once test case failed, it automatically deducts the logs
		for (LogEntry e:logs) {
			
			System.out.println(e.getMessage());
		}
		

	}

}
