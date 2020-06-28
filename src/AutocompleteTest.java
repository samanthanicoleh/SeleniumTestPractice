import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Testing the page 'Autocomplete' on Formy
 */

public class AutocompleteTest {

    WebDriver driver;

    @BeforeTest
    void setup() {
        driver = GlobalInit.setupDriver("https://formy-project.herokuapp.com/autocomplete");
    }

    @Test
    void testCorrectTitle() {
        String actualTitle = driver.findElement(By.xpath("/html/body/div[1]/h1")).getText();
        String expectedTitle = "Autocomplete";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void testAddressAutocomplete() {
        // sending text to text field
        driver.findElement(By.id("autocomplete")).sendKeys("1600 Amphitheatre Parkway, Mountain View");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement autocompleteResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pac-item")));
        autocompleteResult.click();
    }

    @AfterTest
    void closeDriver() {
        driver.quit();
    }

}
