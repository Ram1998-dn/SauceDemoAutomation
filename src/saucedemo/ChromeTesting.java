package saucedemo;
/**
 *
 * BaseUrl = https://www.saucedemo.com/
 * 1. Set up Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current URL.
 * 5. Print the page source.
 * 6. Enter the email in the email field.
 * 7. Enter the password in the password field.
 * 8. Click on the Login Button.
 * 9. Print the current URL.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTesting {
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    // Method to set up the Chrome browser and perform the actions
    public static void setupChromeBrowser() {
        // Set up ChromeDriver (replace the path with your actual ChromeDriver path)
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\Drivers\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        // Open the base URL
        driver.get(baseUrl);

        // Print the title of the page
        System.out.println("Title of the page: " + driver.getTitle());

        // Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Print the page source
        System.out.println("Page Source: " + driver.getPageSource());

        // Enter the email in the email field
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Enter the password in the password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Click on the Login Button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Print the current URL after login attempt
        System.out.println("Current URL after login: " + driver.getCurrentUrl());

        // Navigate back to the base URL
        driver.navigate().to(baseUrl);

        // Refresh the page
        driver.navigate().refresh();

        // Close the browser
        driver.quit();
    }

    // Main method to call the setupChromeBrowser method
    public static void main(String[] args) {
        // Call the method to perform actions
        setupChromeBrowser();
    }
}
