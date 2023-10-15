package Saucedemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LogoutSteps {
    WebDriver driver;

    @Given("I am logged in")
    public void i_am_logged_in() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
    }

    @When("I click the logout button")
    public void i_click_the_logout_button(){
        WebElement LogoutButton = driver.findElement(By.id("logout_sidebar_link"));
        LogoutButton.click();
    }

    @Then("I should be logged out")
    public void i_should_be_logged_out() {
        WebElement loginButton = driver.findElement(By.className("login-button"));
        Assert.assertTrue(loginButton.isDisplayed());
        driver.quit();
    }
}