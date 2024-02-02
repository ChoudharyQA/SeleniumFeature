import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;

public class BasicAuthentication {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		
		//Here we are using Predicate which help us to filter the host from the desired URL for the window alert pop up which can't be handle through simple locators concept
	
		Predicate <URI >uriPredicate =uri ->uri.getHost().contains("httpbin.org");
		
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar"));
		
		driver.get("https://httpbin.org/basic-auth/foo/bar");
		
		
		
		
		

	}

}
