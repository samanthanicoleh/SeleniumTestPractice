import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Testing the page 'Checkbox' on Formy
 */

public class CheckboxTest {

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
        driver.get("https://formy-project.herokuapp.com/checkbox");
    }

    @Test
    void testCorrectTitle() {
        String actualTitle = driver.findElement(By.xpath("/html/body/div[1]/h1")).getText();
        String expectedTitle = "Checkboxes";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void testCheckboxActionOccurs() {
        driver.findElement(By.id("checkbox-1")).click();
        boolean isChecked = driver.findElement(By.tagName("input")).isSelected();
        Assert.assertEquals(isChecked, true);
    }

    @AfterTest
    void closeDriver() {
        driver.quit();
    }

}
