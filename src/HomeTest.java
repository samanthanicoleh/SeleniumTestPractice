import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Testing the 'Home' page on Formy
 */

public class HomeTest {

    public static String driverType = "webdriver.gecko.driver";
    public static String driverLocation = "/Users/samanthaholstead/Downloads/geckodriver";

    WebDriver driver;

    @BeforeTest
    void setup() {
        System.setProperty(driverType, driverLocation);
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        driver.get("https://formy-project.herokuapp.com/");
    }

    @Test
    void testCorrectTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Formy";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
        // Test the header is as expected
    void testPageLoads() {
        String actualHeader = driver.findElement(By.className("display-3")).getText();
        String expectedHeader= "Welcome to Formy";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
        // Test the amount of <li> items
    void testListItemsCount() {
        List<WebElement> elems = driver.findElements(By.cssSelector("div.jumbotron-fluid li"));
        int actualNumber = elems.size();
        int expectedNumber = 14;
        Assert.assertEquals(actualNumber, expectedNumber);
    }

    @Test
        // Test navbar appears and has correct amount of items
    void testNavBarItems() {
        driver.findElement(By.id("navbarDropdownMenuLink")).click();
        List<WebElement> elems = driver.findElements(By.cssSelector("div.dropdown-menu a"));
        int actualNumber = elems.size();
        int expectedNumber = 14;
        Assert.assertEquals(actualNumber, expectedNumber);
    }

    @AfterTest
    void closeDriver() {
        driver.quit();
    }
}
