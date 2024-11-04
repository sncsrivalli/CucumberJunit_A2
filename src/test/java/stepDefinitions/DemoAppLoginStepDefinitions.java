package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoAppLoginStepDefinitions {

	WebDriver driver;

	@Given("I will navigate to skillrary demo app")
	public void i_will_navigate_to_skillrary_demo_app() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapp.skillrary.com/login.php?type=login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("I will login with valid username and password")
	public void i_will_login_with_valid_username_and_password() {
		driver.findElement(By.id("email")).sendKeys("admin" + Keys.TAB + "admin" + Keys.ENTER);
	}

	@Then("I can see Dashboard of the application")
	public void i_can_see_dashboard_of_the_application() {
		String header = driver.findElement(By.xpath("//h1")).getText();
		System.out.println(header);
		driver.quit();
	}
	
	@When("^I will login with (.*) and (.*)$")
	public void i_will_login_with_admin_and_admin(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username + Keys.TAB + password + Keys.ENTER);
	}
}
