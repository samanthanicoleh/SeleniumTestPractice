import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class GlobalInit {

    public static String driverType = "webdriver.gecko.driver";
    public static String driverLocation = "/Users/samanthaholstead/Downloads/geckodriver";

    public static WebDriver setupDriver(String url) {
        System.setProperty(driverType, driverLocation);
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setHeadless(true);
        WebDriver driver = new FirefoxDriver(options);
        driver.get(url);
        return driver;
    }

}
