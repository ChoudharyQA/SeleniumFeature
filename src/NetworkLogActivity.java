import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.Request;
import org.openqa.selenium.devtools.v120.network.model.Response;


public class NetworkLogActivity {

	public static void main(String[] args) {


		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		// Now we want to see what request we have sent from  frontend to backend for selenium 
		
		devTools.addListener(Network.requestWillBeSent(), request->{
			
			Request req= request.getRequest();
			System.out.println(req.getUrl());
					
		});
		
		// Here we are getting the response back from backend to frontend for selenium 
		
		
		devTools.addListener(Network.responseReceived(), response->{
			
			Response res = response.getResponse();
			System.out.println(res.getUrl());
			System.out.println(res.getStatus());
			//Below if loop code, we apply when we only want only failed status code in our selenium console 
			if(res.getStatus().toString().startsWith("4")) {
				
				System.out.println(res.getUrl()+ "is failing with status code" + res.getStatus());
			}
			
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink=\"/library\"]")).click();
		
		
		
		

	}

}
