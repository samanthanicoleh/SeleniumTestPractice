import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Testing the page 'Switch Window' on Formy
 */

public class SwitchWindowTest {

    WebDriver driver;

    @BeforeTest
    void setup() {
        driver = GlobalInit.setupDriver("https://formy-project.herokuapp.com/switch-window");
    }

    @Test
    void testCorrectTitle() {
        String actualTitle = driver.findElement(By.xpath("/html/body/div[1]/h1")).getText();
        String expectedTitle = "Switch Window";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void testNewTabOpens() {
        driver.findElement(By.id("new-tab-button")).click(); // click button to open new tab

        String firstHandle = driver.getWindowHandle();

        for(String tabHandle: driver.getWindowHandles()) {
            driver.switchTo().window(tabHandle);
        }

        driver.switchTo().window(firstHandle);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        String actualNewTitle = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualNewTitle, "Switch Window");
    }

    @Test
    void testAlertOpens() {
        driver.findElement(By.id("alert-button")).click(); // click alert button
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String actualNewTitle = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualNewTitle,"Switch Window");
    }

    @AfterTest
    void closeDriver() {
        driver.quit();
    }

}
