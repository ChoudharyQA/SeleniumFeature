import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CdpCommandsTests {

	public static void main(String[] args) throws InterruptedException {
		
		// We are using below method when there will be no selenium custom commands to handle CDP through executeCdpCommand


		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String, Object> deviceMatrics = new HashMap <String, Object>();
		deviceMatrics.put("width", 600);
		deviceMatrics.put("height", 1000);
		deviceMatrics.put("deviceScaleFactor", 50);
		deviceMatrics.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMatrics);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector("span[class=\"navbar-toggler-icon\"]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("nav div ul li:nth-child(2)")).click();
		
		
		

	}

}
