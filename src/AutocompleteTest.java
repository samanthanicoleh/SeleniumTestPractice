import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutocompleteTest {

    String driverLocation = HomeTest.driverLocation;
    String driverType = HomeTest.driverType;
    WebDriver driver;

    @BeforeTest
    void setup() {
        System.setProperty(driverType, driverLocation);
        driver = new FirefoxDriver();
    }

    @Test
    void testCorrectTitle() {
        driver.get("https://formy-project.herokuapp.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Formy";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterTest
    void closeDriver() {
        driver.close();
    }

}
