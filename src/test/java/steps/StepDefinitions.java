package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	WebDriver driver;
	
	@Given("user starts {string} browser")
	public void user_starts_browser(String browserName) {
	   
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
	}

	@Given("user launch app using url {string}")
	public void user_launch_app_using_url(String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
	    
	}



	@When("user enters text {string}	in textbox using xpath {string}")
	public void user_enters_text_in_textbox_using_xpath(String text,String xpath) {
	    
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user clicks login button using xpath {string}")
	public void user_clicks_login_button_using_xpath(String xpath) {
	   
		driver.findElement(By.xpath(xpath)).click();
	}

	@Then("user validates title to be {string}")
	public void user_validates_title_to_be(String string) {
	    
		Assert.assertEquals(string, driver.getTitle());
	}

	//hooks  are same as @AfterMethod and @BeforeMEthod in TestNG
	@After
	public void teardown()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

	@When("user clicks on link using xpath {string}")
	public void user_clicks_on_link_using_xpath(String xpath) {
	    
		driver.findElement(By.xpath(xpath)).click();
	}

}
