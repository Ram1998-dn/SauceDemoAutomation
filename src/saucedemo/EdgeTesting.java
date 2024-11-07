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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeTesting {
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    // Method to set up the browser and perform actions
    public static void setupBrowser(String browser) {
        // Initialize browser based on input
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Soft\\Drivers\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Soft\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Soft\\Drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Unsupported browser! Please use 'chrome', 'firefox', or 'edge'.");
            return;
        }

        // Open URL
        driver.get(baseUrl);

        // Print the title of the page
        System.out.println("Title of the page: " + driver.getTitle());

        // Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Print the page source
        System.out.println("Page Source: " + driver.getPageSource());

        // Enter email in the email field
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Enter password in the password field
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

    // Main method to execute setup for different browsers
    public static void main(String[] args) {
        // Set browser to "chrome", "firefox", or "edge"
        String browser = "edge"; // Change this to test with different browsers

        // Run setupBrowser method for the selected browser
        setupBrowser(browser);
    }
}
