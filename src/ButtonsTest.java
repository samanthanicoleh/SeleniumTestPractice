import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Testing the page 'Buttons' on Formy
 */

public class ButtonsTest {

    WebDriver driver;

    @BeforeTest
    void setup() {
        driver = GlobalInit.setupDriver("https://formy-project.herokuapp.com/buttons");
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
