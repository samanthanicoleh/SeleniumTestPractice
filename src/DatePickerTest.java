import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Testing the page 'DatePicker' on Formy
 */

public class DatePickerTest {

    WebDriver driver;

    @BeforeTest
    void setup() {
        driver = GlobalInit.setupDriver("https://formy-project.herokuapp.com/datepicker");
    }

    @Test
    void testCorrectTitle() {
        String actualTitle = driver.findElement(By.xpath("/html/body/div[1]/h1")).getText();
        String expectedTitle = "Datepicker";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void testDatePickerAppears() {
        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.sendKeys("02/10/2020");
        boolean popupShown = driver.findElement(By.className("datepicker")).isDisplayed();
        Assert.assertEquals(popupShown, true);
    }

    @Test
    void testDatePickerDisappears() {
        // test that the popup disappears after selecting a date
        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.sendKeys("02/10/2020");
        dateField.sendKeys(Keys.RETURN);
        int popupShown = driver.findElements(By.className("datepicker")).size();
        Assert.assertEquals(popupShown, 0);
    }

    @AfterTest
    void closeDriver() {
        driver.quit();
    }

}
