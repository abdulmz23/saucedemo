package Saucedemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class AddToCart {
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

    @When("I add backpack to the cart")
    public void i_add_backpack_to_the_cart(){
        WebElement AddtoCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        AddtoCartButton.click();
    }

    @Then("I should see the cart")
    public void i_should_see_the_cart() {
        WebElement CartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertTrue(CartBadge.isDisplayed());
        driver.quit();
    }
}