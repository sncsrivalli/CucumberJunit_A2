package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwagLabsLoginStepDefinitions {

	WebDriver driver;

	@Before
	public void beforeScenario() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterStep
	public void afterStep(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshots/" + scenario.getName() + scenario.getLine() + ".png");
			FileUtils.copyFile(src, dest);
		}
	}

	@Given("I navigate to Swag labs")
	public void i_navigate_to_swag_labs() {
		driver.get("https://www.saucedemo.com/");
	}

	@When("I login to swag labs")
	public void i_login_to_swag_labs() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Then("Swag Labs home page displays")
	public void swag_labs_home_page_displays() {
		if (driver.findElement(By.cssSelector(".app_logo")).isDisplayed())
			System.out.println("Login success");
		else
			System.out.println("Login failed");
	}

	@When("^I login to swag labs using (.*) and (.*)$")
	public void i_login_to_swag_labs_using_different_credentials(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
	}

	@After
	public void afterScenario() {
		driver.quit();
	}
}
