package pagetesting;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdef1 {
	RemoteWebDriver driver;
	@Given("open the browser")
	public void open_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	    
	}

	@When("launch the {string}")
	public void launch_the(String string) throws Exception {
		driver.get(string);
		Thread.sleep(3000);
	    
	}

	@Then("check the login scenario working correctly or not {string} and {string}")
	public void check_the_login_scenario_working_correctly_or_not_and(String string, String string2) throws Exception {
	driver.findElement(By.name("username")).sendKeys(string);
	driver.findElement(By.name("password")).sendKeys(string2);
	driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	Thread.sleep(5000);
	File dest=new File("target\\test.png"); //create a new file in HDD
	File src=driver.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src,dest);
	Thread.sleep(3000);
        System.out.println("Test has been Executed");
	    
	}

	@Then("close the site")
	public void close_the_site() {
		driver.close();
	   
	    
	}


}
