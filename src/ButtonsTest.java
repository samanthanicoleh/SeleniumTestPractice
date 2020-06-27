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
 * Testing the page 'Buttons' on Formy
 */

public class ButtonsTest {

    String driverLocation = HomeTest.driverLocation;
    String driverType = HomeTest.driverType;
    WebDriver driver;

    @BeforeTest
    void setup() {
        System.setProperty(driverType, driverLocation);
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setHeadless(true);
        driver = new FirefoxDriver();
        driver.get("https://formy-project.herokuapp.com/buttons");
    }

    @Test
    void testCorrectNumberOfButtons() {
        List<WebElement> elemsCount = driver.findElements(By.tagName("button"));
        int actualNumber = elemsCount.size();
        int expectedNumber = 13;
        Assert.assertEquals(actualNumber, expectedNumber);
    }

    @Test
    void testDropdownButton() {
        driver.findElement(By.id("btnGroupDrop1")).click();
        String actualText = driver.findElement(By.cssSelector("div.show:nth-child(2) > a:nth-child(1)")).getText();
        String expectedText = "Dropdown link 1";
        Assert.assertEquals(actualText, expectedText);
    }

    @AfterTest
    void closeDriver() {
        driver.quit();
    }

}
