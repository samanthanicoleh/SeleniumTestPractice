import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Testing the page 'File Upload' on Formy
 */

public class FileUploadTest {

    WebDriver driver;

    @BeforeTest
    void setup() {
        driver = GlobalInit.setupDriver("https://formy-project.herokuapp.com/fileupload");
    }

    @Test
    void testCorrectTitle() {
        String actualTitle = driver.findElement(By.xpath("/html/body/div[1]/h1")).getText();
        String expectedTitle = "File upload";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    void testFileUpload() {
        driver.findElement(By.id("file-upload-field")).sendKeys("filetoupload.jpg");
    }

    @Test
    void testResetButton() {
        driver.findElement(By.className("btn-warning")).click();
        String uploadTextField = driver.findElement(By.id("file-upload-field")).getText();
        Assert.assertEquals(uploadTextField, "");
    }

    @AfterTest
    void closeDriver() {
        driver.quit();
    }

}
