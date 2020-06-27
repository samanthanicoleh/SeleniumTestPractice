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
 * Testing the page 'Enabled and Disabled Elements' on Formy
 */

public class EnabledAndDisabledElementsTest {

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
        driver.get("https://formy-project.herokuapp.com/enabled");
    }

    @Test
    void testCorrectTitle() {
        String actualTitle = driver.findElement(By.xpath("/html/body/div[1]/h1")).getText();
        String expectedTitle = "Enabled and Disabled elements";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void testDisabledField() {
        boolean disabledInput = driver.findElement(By.id("disabledInput")).isEnabled();
        Assert.assertEquals(disabledInput, false);
    }

    @Test
    void testEnabledField() {
        boolean enabledInput = driver.findElement(By.id("input")).isEnabled();
        Assert.assertEquals(enabledInput, true);
    }

    @AfterTest
    void closeDriver() {
        driver.quit();
    }

}
