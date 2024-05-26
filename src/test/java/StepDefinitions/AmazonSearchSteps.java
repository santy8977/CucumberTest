package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class AmazonSearchSteps {
    WebDriver driver;

    @Given("I am on the Amazon homepage")
    public void i_am_on_the_Amazon_homepage() {
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.amazon.in");
    }

    @When("I search for laptop")
    public void i_search_for(String keyword) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword + Keys.RETURN);
    }

    @Then("I should see search results for {string}")
    public void i_should_see_search_results_for(String keyword) {
        // Verify search results
        assertTrue(driver.getTitle().contains(keyword));
    }

    @Then("I should see a message indicating no search results found")
    public void i_should_see_no_search_results_found_message() {
        // Verify no search results message
        assertTrue(driver.getPageSource().contains("No results for"));
    }

    @After
    public void closeBrowser() {
        // Close the browser
        driver.quit();
    }
}
