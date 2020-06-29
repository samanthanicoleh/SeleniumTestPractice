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
 * Testing the page 'Radio Buttons' on Formy
 */

public class RadioButtonsTest {

    WebDriver driver;

    @BeforeTest
    void setup() {
        driver = GlobalInit.setupDriver("https://formy-project.herokuapp.com/radiobutton");
    }

    @Test
    void testCorrectTitle() {
        String actualTitle = driver.findElement(By.xpath("/html/body/div[1]/h1")).getText();
        String expectedTitle = "Radio buttons";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void firstRadioButtonSelected() {
        boolean firstButtonSelected = driver.findElement(By.id("radio-button-1")).isSelected();
        Assert.assertEquals(firstButtonSelected, true);
    }

    @Test
    void onlyOneSelection() {
        driver.findElement(By.cssSelector("div.form-check:nth-child(6) > input:nth-child(1)")).click(); // click 2nd radio btn
        boolean firstButtonSelected = driver.findElement(By.id("radio-button-1")).isSelected();
        Assert.assertEquals(firstButtonSelected, false);
    }

    @AfterTest
    void closeDriver() {
        driver.quit();
    }

}
