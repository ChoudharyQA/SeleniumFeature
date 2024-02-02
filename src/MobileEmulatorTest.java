import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//We need to send command to CDP (ChromeDev tool protocol) and then CDP will invoke and get access to chrome dev tool
		
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector("span[class=\"navbar-toggler-icon\"]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("nav div ul li:nth-child(2)")).click();
		
		
		// From the above code, the website will open in IPhone so there is no need of Appium mobile automation tool now 
		
		

	}

}
