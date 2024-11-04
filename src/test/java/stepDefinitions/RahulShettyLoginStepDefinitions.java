package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RahulShettyLoginStepDefinitions {
	WebDriver driver;
	
	@Given("Navigate to Rahul Shetty App")
	public void navigate_to_rahul_shetty_app() {
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("Give rahulshettyacademy and learning to login")
	public void give_rahulshettyacademy_and_learning_to_login() {
	   driver.findElement(By.id("username")).sendKeys("rahulshettyacademy" + Keys.TAB + "learning" 
			   																		+ Keys.ENTER);
	}

	@Then("Shop Name should be displayed")
	public void shop_name_should_be_displayed() {
	   String header = driver.findElement(By.xpath("//h1")).getText();
	   System.out.println(header);
	   driver.quit();
	}
	
	@When("^Login as (.*) and (.*)$")
	public void login_as_rahulshettyacademy_and_learning(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username + Keys.TAB + password + Keys.ENTER);
	}
}
