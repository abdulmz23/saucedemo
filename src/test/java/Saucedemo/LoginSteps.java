package Saucedemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    WebDriver driver;

    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_saucedemo_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        WebElement inventoryLabel = driver.findElement(By.className("inventory_list"));
        Assert.assertTrue(inventoryLabel.isDisplayed());
        driver.quit();
    }

    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("invalid_user");
        passwordField.sendKeys("invalid_password");
        loginButton.click();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorElement.isDisplayed());
        driver.quit();
    }
}
